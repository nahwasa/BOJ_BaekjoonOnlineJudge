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
		int tc = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < tc; i++) {
			String in = br.readLine();			
			
			for (int a = 0; a < in.length(); a++) {
				boolean continueChk = true;
				for (int b = 0; b < str.length(); b++) {
					if (str.charAt(b) == in.charAt((a+b) % in.length())) {
						if (b == str.length()-1) {
							cnt++;		
							continueChk = false;
						}
						continue;
					} else {
						break;
					}
				}		
				if (!continueChk)
					break;
			}			
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
