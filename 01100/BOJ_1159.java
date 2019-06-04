import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] cnt = new int['z'-'a'+1];
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			cnt[s.charAt(0) - 'a']++;
		}
		
		boolean chk = false;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] >= 5) {
				chk = true;
				bw.write((char)(i + 'a') + "");
			}
		}
			
		if (!chk)
			bw.write("PREDAJA\n");
		else
			bw.newLine();
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
