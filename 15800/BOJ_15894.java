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
		
		BigInteger n = new BigInteger(br.readLine());
		bw.write( n.multiply(new BigInteger("4")).toString() + "\n" );
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
