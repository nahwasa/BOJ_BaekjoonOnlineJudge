import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			sb.append(a.charAt(i));
			sb.append(b.charAt(i));
		}
		
		while (sb.length() > 2) {
			String tmp = sb.toString();
			sb = new StringBuilder();
			for (int i = 0; i < tmp.length()-1; i++) {
				sb.append( (tmp.charAt(i)-'0' + tmp.charAt(i+1)-'0') % 10 );
			}
		}
		
		bw.write(sb.toString());
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
