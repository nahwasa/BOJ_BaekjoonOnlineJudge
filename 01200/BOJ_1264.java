import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		while (true) {
			String s = br.readLine();
			if (s.equals("#"))
				break;
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case 'a': case 'A':	case 'e': case 'E': case 'i':
				case 'I': case 'o': case 'O': case 'u': case 'U':
					cnt++;
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
