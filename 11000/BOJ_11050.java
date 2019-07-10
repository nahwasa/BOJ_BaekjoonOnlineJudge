import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bw.write(String.format("%d\n", factorial(N) / (factorial(K) * factorial(N-K))));
		bw.flush();
		br.close();
		bw.close();		
	}
	private static int factorial(int n) {
		int result = 1;
		for (int i = 2; i <= n; i++)
			result*=i;
		return result;
	}
}
