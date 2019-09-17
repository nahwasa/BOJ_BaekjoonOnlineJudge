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
		BigInteger bi = new BigInteger("2");
		bi = bi.pow(Integer.parseInt(br.readLine()));		
		bi = bi.multiply(bi.subtract(new BigInteger("1"))).divide(new BigInteger("2"));
		bw.write(bi.toString(2));
		bw.flush();
		bw.close();
		br.close();
	}
}
