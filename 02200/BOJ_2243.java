import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	static int[] seg;
	static final int TOT = 1000000;
	static BufferedWriter bw;
	
	private static void update(int n, int s, int e, int t, int v) {
		if (t<s || t>e)
			return;
		if (s==e) {
			seg[n]+=v;
			return;
		}
		int m = (s+e)/2;
		update(n*2,s,m,t,v);
		update(n*2+1,m+1,e,t,v);
		seg[n]=seg[n*2]+seg[n*2+1];
	}
	
	private static void query(int n, int s, int e, int r) throws IOException {
		seg[n]--;
		if (s==e) {	// 리프노드에 도달한 경우 해당 맛이 정답임
			bw.write(s + "\n");
			return;
		}
		int m = (s+e)/2;
		if (r > seg[n*2])	// 답이 우측자식 중 있는 경우.
			query(n*2+1,m+1,e,r-seg[n*2]);
		else
			query(n*2,s,m,r);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int h = (int) Math.ceil(Math.log(TOT) / Math.log(2));
		seg = new int[1<<(h+1)];
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "1" :
				int r = Integer.parseInt(st.nextToken());
				query(1, 1, TOT, r);
				break;
			case "2" :
				int t = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				update(1, 1, TOT, t, n);
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
