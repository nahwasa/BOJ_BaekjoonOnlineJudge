import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'P')	cnt++;		
			else {
				if (cnt < 2 || i+1 == s.length()) {		
					cnt = 100;
					break;
				}
				if (s.charAt(i+1) == 'P') {
					cnt--;
					i++;
				}
			}			
		}
		if (cnt == 1)
			bw.write("PPAP\n");
		else
			bw.write("NP\n");
		bw.flush();		
		bw.close();
		br.close();
	}
}
