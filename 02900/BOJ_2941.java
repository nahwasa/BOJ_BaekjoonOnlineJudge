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
		String str = br.readLine();
		int cnt = 0;
		
		String[] words = {
				"c=",
				"c-",
				"dz=",
				"d-",
				"lj",
				"nj",
				"s=",
				"z="
		};

		for (int i = 0; i < words.length; i++) {
			
			while(true) {
				if (!str.contains(words[i])) {
					break;
				} else {
					str = str.substring(0, str.lastIndexOf(words[i])) 
							+ "/" + str.substring(str.lastIndexOf(words[i]) + words[i].length());
					cnt++;					
				}
			}
			
		}	
		
		StringTokenizer st = new StringTokenizer(str, "/");
		while (st.hasMoreTokens()) {
			cnt += st.nextToken().length();
		}		
		
		bw.write(cnt + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}	

}
