import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int init(boolean type, int[] arr, int[][] seg, int n, int s, int e) {
		if (type) {
			return s==e?(seg[n][0]=arr[s]):(seg[n][0] = Math.min(init(type,arr,seg,n*2,s,(s+e)/2), init(type,arr,seg,n*2+1,(s+e)/2+1,e)));
		} else {
			return s==e?(seg[n][1]=arr[s]):(seg[n][1] = Math.max(init(type,arr,seg,n*2,s,(s+e)/2), init(type,arr,seg,n*2+1,(s+e)/2+1,e)));
		}		
	}
	
	private static int min(int[][] seg, int n, int s, int e, int l, int r) {
		if (l>e || r<s) 	return Integer.MAX_VALUE;
		if (l<=s && e<=r) 	return seg[n][0];
		return Math.min(min(seg,n*2,s,(s+e)/2,l,r), min(seg,n*2+1,(s+e)/2+1,e,l,r));
	}
	
	private static int max(int[][] seg, int n, int s, int e, int l, int r) {
		if (l>e || r<s) 	return Integer.MIN_VALUE;
		if (l<=s && e<=r) 	return seg[n][1];
		return Math.max(max(seg,n*2,s,(s+e)/2,l,r), max(seg,n*2+1,(s+e)/2+1,e,l,r));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		int[] arr = new int[N];
		int[][] seg = new int[1<<(h+1)][2];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		init(true, arr, seg, 1, 0, N-1);
		init(false, arr, seg, 1, 0, N-1);
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			bw.write(min(seg, 1, 0, N-1, l, r) + " " + max(seg, 1, 0, N-1, l, r) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
