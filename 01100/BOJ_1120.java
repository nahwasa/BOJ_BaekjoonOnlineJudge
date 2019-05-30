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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int max = 0;
		for (int i = 0; i <= b.length() - a.length(); i++) {
			int cnt = 0;
			for (int k = 0; k < a.length(); k++) {
				if (a.charAt(k) == b.charAt(k + i))
					cnt++;
			}
		
			if (cnt > max)
				max = cnt;
		}
		
		bw.write(a.length() - max + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
