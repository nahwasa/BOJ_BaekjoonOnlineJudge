import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());				
		String s = br.readLine();
		
		for (int i = 1; i < n*2; i++) {
			if (s.charAt(i-1) == s.charAt(i)) {
				bw.write("No\n");
				bw.flush();
				br.close();
				bw.close();
				return;
			}
		}
		
		bw.write("Yes\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
