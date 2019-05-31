import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String prefix = st.nextToken();
		String postfix = st.nextToken();
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (s.length() < prefix.length() + postfix.length()) {
				bw.write("NE\n");
				continue;
			}
			
			if (s.indexOf(prefix) == 0 && s.lastIndexOf(postfix) == s.length()-postfix.length())
				bw.write("DA\n");
			else
				bw.write("NE\n");
		}
		
		
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}	
