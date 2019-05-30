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
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char c = (char)(s.charAt(i) - 3);
			if (c < 'A')
				c += 'Z' - 'A' + 1;
			sb.append(c);
		}
		
		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();		
	}	
}
