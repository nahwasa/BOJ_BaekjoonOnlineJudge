import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		C(N,1);
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void C(int n, int idx) {
		if (n==1) {
			result=idx;
			return;
		}
		C(((n&1)==0)?n/2:n*3+1,++idx);
	}
}
