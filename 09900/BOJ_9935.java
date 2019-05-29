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
		String boom = br.readLine();
		
		char[] st = new char[str.length()];
		int idx = 0;
		
		for (int i = 0; i < str.length(); i++) {
			st[idx] = str.charAt(i);			
			
			if (st[idx] == boom.charAt(boom.length()-1) && idx+1 >= boom.length()) {
				int cnt = 0;
				for (int j = idx, k = boom.length()-1; k >= 0; j--, k--) {					
					if (st[j] != boom.charAt(k))
						break;
					cnt++;
				}
				if (cnt == boom.length()) 
					idx -= cnt;					

			}
			
			if (i != str.length()-1)
				idx++;
			
		}		
		
		if (idx <= -1)
			bw.write("FRULA\n");
		else {
			for (int i = 0; i <= idx; i++)
				bw.write(st[i]);
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
