import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		String s = br.readLine();
		int[] cnt = new int['z'-'a' + 1];
		
		for (int i = 0; i < s.length(); i++) {
			cnt[ s.charAt(i) - 'a' ]++;
		}
		
		for (int i = 0; i < cnt.length; i++) {
			bw.write(cnt[i] + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
