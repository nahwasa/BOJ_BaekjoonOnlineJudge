import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++) {
			if (N%i==0)
				K--;
			if (K==0) {
				bw.write(i+"\n");
				bw.flush();
				return;
			}
		}
		bw.write("0\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
