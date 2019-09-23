import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr, seg;
	
	// make seg tree
	private static void init(int n, int s, int e) {
		if (s==e) {
			seg[n] = arr[s];
			return;
		}
		init(n*2,s,(s+e)/2);
		init(n*2+1,(s+e)/2+1,e);
		seg[n] = (seg[n*2] * seg[n*2+1]);
	}

	// update value
	private static void update(int n, int s, int e, int idx, int newVal) {
		if (idx<s || idx>e)
			return;
		if (s==e) {
			seg[n] = newVal;
			return;
		}
		update(n*2,s,(s+e)/2,idx,newVal);
		update(n*2+1,(s+e)/2+1,e,idx,newVal);
		seg[n] = (seg[n*2] * seg[n*2+1]);
	}
	
	// query
	private static int query(int n, int s, int e, int l, int r) {
		if (l>e || r<s)
			return 1;
		if (l<=s && e<=r)
			return seg[n];
		int q1 = query(n*2,s,(s+e)/2,l,r);
		int q2 = query(n*2+1,(s+e)/2+1,e,l,r);
		return q1 * q2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = null;
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int h = (int)Math.ceil(Math.log(N) / Math.log(2));
			arr = new int[N];
			seg = new int[1<<(h+1)];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int it = Integer.parseInt(st.nextToken());
				if (it>0) it=1;
				else if (it<0) it=-1;				
				arr[i] = it;
			}
			init(1, 0, N-1);
			while (M-->0) {
				st = new StringTokenizer(br.readLine());			
				if (st.nextToken().equals("C")) {	//change arr[target] to value
					int target = Integer.parseInt(st.nextToken()) - 1;	//-1 : seq to idx
					int value = Integer.parseInt(st.nextToken());
					if (value>0) value=1;
					else if (value<0) value=-1;
					update(1, 0, N-1, target, value);
				} else {	//print sum between [l] to [r]
					int l = Integer.parseInt(st.nextToken()) - 1;
					int r = Integer.parseInt(st.nextToken()) - 1;
					int res = query(1, 0, N-1, l, r);
					if (res > 0) 
						bw.write("+");
					else if (res < 0)
						bw.write("-");
					else
						bw.write("0");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
