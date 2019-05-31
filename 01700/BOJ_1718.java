import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String str = br.readLine();
		String sec = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append(' ');
				continue;
			}
			
			int tmp = str.charAt(i) - sec.charAt(i % sec.length()) + 'a' - 1;
		
			if (tmp >= 'a')
				sb.append((char)tmp);
			else
				sb.append((char)(tmp + 'z' - 'a' + 1));
		}
		
		bw.write(sb.toString());
		
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}	
