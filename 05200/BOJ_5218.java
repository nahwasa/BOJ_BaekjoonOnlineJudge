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
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String a = st.nextToken();
			String b = st.nextToken();
			
			bw.write("Distances: ");
			for (int j = 0; j < a.length(); j++) {
				int charA = a.charAt(j);
				int charB = b.charAt(j);
				
				if (charB >= charA)
					bw.write((charB - charA) + (j==a.length()-1?"\n":" "));
				else
					bw.write((charB+26 - charA) + (j==a.length()-1?"\n":" "));	
			}			
		}
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
