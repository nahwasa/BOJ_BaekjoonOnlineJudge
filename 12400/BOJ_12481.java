import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String s = br.readLine();
			long bit0Chk = 0l, bit1Chk = 0l;
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case '0' :
					bit0Chk |= 1l << (s.length()-1-i);
					break;
				case '1' :
					bit1Chk |= 1l << (s.length()-1-i);
					break;
				default :
					// ?인경우 -> 처리안함
				}
			}
			long tmp = 1l;
			for (long l = 1; ; l++) {
				tmp = l * l;
				if ((tmp&bit0Chk) == 0 && (tmp&bit1Chk) == bit1Chk)
					break;
			}			
			bw.write(String.format("Case #%d: %s\n", tc, Long.toString(tmp, 2)));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
