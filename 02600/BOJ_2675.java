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
		
		for (int i = 0; i < n; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());			
			bw.write( printNewlyStr(st) );				
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}

	private static String printNewlyStr(StringTokenizer st) {
		String result = "";
		int cnt = Integer.parseInt(st.nextToken());
		String str = st.nextToken();
		
		for (int i = 0; i < str.length(); i++) {
			for (int k = 0; k < cnt; k++) {
				result += str.charAt(i);
			}
		}
		
		result += "\n";
		return result;
	}	
}
