import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			BigDecimal bd = new BigDecimal(0);
			while(true) {
				String s = br.readLine();
				if (s.equals("0")) break;
				bd = bd.add(new BigDecimal(s));
			}
			BigDecimal tmp = bd.stripTrailingZeros();
			if (tmp.toString().contains("E") || !tmp.toString().contains("."))
				bw.write(bd.toBigInteger().toString() + "\n");
			else
				bw.write(tmp.toString() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
