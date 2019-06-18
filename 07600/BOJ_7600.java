import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine().toUpperCase();
			if (s.equals("#"))
				break;
			boolean[] chk = new boolean['Z'-'A'+1];
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					chk[s.charAt(i) - 'A'] = true;
			}
			int cnt = 0;
			for (boolean b : chk)
				if (b) cnt++;
			bw.write(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
