import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		recFunc(N,0,0);
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static void recFunc(int N, int c, int r) {		
		if (N == 1) {
			visit(c, r);
			visit(c+1, r);
			visit(c, r+1);
			visit(c+1, r+1);
			return;
		}
		int pow = (int)Math.pow(2, N);
		if (C >= c && C < c+pow && R >= r && R < r+pow ) {	
			int tmp = (int)Math.pow(2, N-1);
			recFunc(N-1, c, r);
			recFunc(N-1, c+tmp, r);
			recFunc(N-1, c, r+tmp);
			recFunc(N-1, c+tmp, r+tmp);
		} else {
			cnt += pow * pow;
			return;
		}
	}
	
	private static void visit(int c, int r) {
		if (R==r && C==c) {
			System.out.println(String.valueOf(cnt));
			System.exit(0);
		}
		cnt++;
	}
}
