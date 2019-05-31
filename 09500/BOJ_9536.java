import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashSet<String> hs;
		
		for (int i = 0; i < tc; i++) {
			String s = br.readLine();
			hs = new HashSet<String>();			
			
			while (true) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("what"))
					break;
				st.nextToken(); 	// 필요없음				
				hs.add(st.nextToken());
			}
			
			st = new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				String tmp = st.nextToken();
				if (!hs.contains(tmp)) {
					bw.write(tmp);
					
					if (st.hasMoreTokens())
						bw.write(" ");
					else
						bw.newLine();
				}
					
			}
		}
		
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}	
