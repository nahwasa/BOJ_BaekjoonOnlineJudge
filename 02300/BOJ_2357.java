import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static SegNode init(int[] arr, SegNode[] seg, int n, int s, int e) {
		if (s==e)
			return seg[n]=new SegNode(arr[s]);
		SegNode sn1 = init(arr,seg,n*2,s,(s+e)/2);
		SegNode sn2 = init(arr,seg,n*2+1,(s+e)/2+1,e);
		return seg[n] = new SegNode(Math.min(sn1.min, sn2.min), Math.max(sn1.max, sn2.max));
	}
	
	private static int[] result(SegNode[] seg, int n, int s, int e, int l, int r) {
		if (l>e || r<s) 	return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		if (l<=s && e<=r) 	return new int[] {seg[n].min, seg[n].max};
		int[] sn1 = result(seg,n*2,s,(s+e)/2,l,r);
		int[] sn2 = result(seg,n*2+1,(s+e)/2+1,e,l,r);
		
		return new int[] {Math.min(sn1[0], sn2[0]), Math.max(sn1[1], sn2[1])};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		int[] arr = new int[N];
		SegNode[] seg = new SegNode[1<<(h+1)];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		init(arr, seg, 1, 0, N-1);
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			int[] result = result(seg, 1, 0, N-1, l, r);
			bw.write(result[0] + " " + result[1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}

class SegNode {
	int min, max;
	public SegNode(int min, int max) {
		this.min = min;
		this.max = max;
	}	
	public SegNode(int num) {
		min=max=num;
	}	
}
