import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		BigInteger bi = new BigInteger("0");
		for (int n = 2; n <= N; n++) {
			if ((n&1)==0)
				bi = bi.multiply(new BigInteger("2")).add(new BigInteger("1"));
			else
				bi = bi.multiply(new BigInteger("2")).subtract(new BigInteger("1"));
		}
		bw.write(bi.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
