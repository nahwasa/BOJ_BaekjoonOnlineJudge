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
		BigInteger bi = new BigInteger(br.readLine());
		boolean chk = false;
		for (int radix = 2; radix <= 10; radix++) {
			String tmp = bi.toString(radix);
			int i = 0;
			for (; i < tmp.length(); i++) {
				if (tmp.charAt(i) != tmp.charAt(tmp.length()-i-1)) break;
			}
			if (i==tmp.length()) {
				chk = true;
				bw.write(String.format("%d %s\n", radix, tmp));
			}			
		}
		if (!chk) bw.write("NIE\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
