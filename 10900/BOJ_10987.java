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
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
				cnt++;
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
