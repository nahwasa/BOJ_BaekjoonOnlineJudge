import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static long[] arr, seg;
	
	// make seg tree
	private static void init(int n, int s, int e) {
		if (s==e) {
			seg[n] = arr[s];
			return;
		}
		init(n*2,s,(s+e)/2);
		init(n*2+1,(s+e)/2+1,e);
		seg[n] = seg[n*2] + seg[n*2+1];
	}

	// update value
	private static void update(int n, int s, int e, int idx, long diff) {
		if (idx<s || idx>e)
			return;
		if (s==e) {
			seg[n] += diff;
			return;
		}
		update(n*2,s,(s+e)/2,idx,diff);
		update(n*2+1,(s+e)/2+1,e,idx,diff);
		seg[n] += diff;
	}
	
	// query
	private static long query(int n, int s, int e, int l, int r) {
		if (l>e || r<s)
			return 0;
		if (l<=s && e<=r)
			return seg[n];
		long q1 = query(n*2,s,(s+e)/2,l,r);
		long q2 = query(n*2+1,(s+e)/2+1,e,l,r);
		return q1 + q2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		arr = new long[N];
		seg = new long[1<<(h+1)];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		init(1, 0, N-1);
		while (M-->0) {
			st = new StringTokenizer(br.readLine());			
			if (Integer.parseInt(st.nextToken())==1) {	//change arr[target] to value
				int target = Integer.parseInt(st.nextToken()) - 1;	//-1 : seq to idx
				long value = Long.parseLong(st.nextToken());
				long diff = value - arr[target];
				arr[target] = value;
				update(1, 0, N-1, target, diff);
			} else {	//print sum between [l] to [r]
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				bw.write(query(1, 0, N-1, l, r) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
