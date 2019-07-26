import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger bi1 = new BigInteger(st.nextToken() + st.nextToken());
		BigInteger bi2 = new BigInteger(st.nextToken() + st.nextToken());
		bw.write(bi1.add(bi2).toString());
		bw.newLine();
		bw.close();
		br.close();
	}
}
