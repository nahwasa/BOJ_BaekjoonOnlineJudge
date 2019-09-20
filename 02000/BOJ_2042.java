import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static long init(long[] arr, long[] seg, int n, int s, int e) {
		return s==e?(seg[n]=arr[s]):(seg[n] = init(arr,seg,n*2,s,(s+e)/2) + init(arr,seg,n*2+1,(s+e)/2+1,e));
	}

	private static void update(long[] seg, int n, int s, int e, int idx, long diff) {
		if (idx<s || idx>e) return;
		seg[n] += diff;
		if (s==e) 			return;
		update(seg,n*2,s,(s+e)/2,idx,diff);
		update(seg,n*2+1,(s+e)/2+1,e,idx,diff);
	}
	
	private static long sum(long[] seg, int n, int s, int e, int l, int r) {
		if (l>e || r<s) 	return 0;
		if (l<=s && e<=r) 	return seg[n];
		return sum(seg,n*2,s,(s+e)/2,l,r) + sum(seg,n*2+1,(s+e)/2+1,e,l,r);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		long[] arr = new long[N];
		long[] seg = new long[1<<(h+1)];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		init(arr, seg, 1, 0, N-1);
		while (M-->0) {
			st = new StringTokenizer(br.readLine());			
			if (Integer.parseInt(st.nextToken())==1) {	//change arr[target] to value
				int target = Integer.parseInt(st.nextToken()) - 1;	//-1 : seq to idx
				long value = Long.parseLong(st.nextToken());
				long diff = value - arr[target];
				arr[target] = value;
				update(seg, 1, 0, N-1, target, diff);
			} else {	//print sum between [l] to [r]
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				bw.write(sum(seg, 1, 0, N-1, l, r) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
