import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			String s = br.readLine().trim().toLowerCase();
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case 'a' : case 'e' : case 'i' : case 'o' : case 'u' :
					cnt2++;
					break;
				case ' ' :
					break;
				default :
					cnt1++;					
				}
			}
			bw.write(cnt1 + " " + cnt2 + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
