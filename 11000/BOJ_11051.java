import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	private static final String MOD_VAL = "10007";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());		
		bw.write(factorial(N).divide((factorial(K).multiply(factorial(N-K)))).mod(new BigInteger(MOD_VAL)).toString()+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
	private static BigInteger factorial(int n) {
		BigInteger result = new BigInteger("1");
		for (int i = 2; i <= n; i++)
			result = result.multiply(new BigInteger(String.valueOf(i)));
		return result;
	}
}
