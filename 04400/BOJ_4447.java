import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			String s = br.readLine();
			int cntG = 0;
			int cntB = 0;
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case 'G': case'g':
					cntG++;
					break;
				case 'B': case'b':
					cntB++;
					break;
				}
			}
			if (cntG == cntB)
				bw.write(String.format("%s is %s\n", s, "NEUTRAL"));
			else if (cntG > cntB)
				bw.write(String.format("%s is %s\n", s, "GOOD"));
			else
				bw.write(String.format("%s is %s\n", s, "A BADDY"));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
