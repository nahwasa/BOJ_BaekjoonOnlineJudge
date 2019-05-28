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
		BigInteger num3 = new BigInteger("3");
		BigInteger num0 = new BigInteger("0");
		
		if (n.compareTo(num0) == 0) {
			bw.write("NO\n");
			bw.flush();
			br.close();
			bw.close();	
			return;
		}
		
		int i = 0;
		BigInteger tmp = new BigInteger("1");
		while (true) {			
			if (tmp.compareTo(n) >= 0)
				break;
			
			tmp = tmp.multiply(num3);
			i++;
		}
		
		for (; i >= 0; i--) {		
			if (n.compareTo(tmp) >= 0) {
				n = n.subtract(tmp);
			}
			
			if (n.compareTo(num0) == 0) {
				bw.write("YES\n");
				bw.flush();
				br.close();
				bw.close();	
				return;
			}
			
			tmp = tmp.divide(num3);
		}
		
		bw.write("NO\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
