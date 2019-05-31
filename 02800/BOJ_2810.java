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
		
		int cnt = 1;
		
		for (int i = 0; i < s.length();) {
			switch(s.charAt(i)) {
			case 'S' :
				cnt++;
				i++;
				break;
			case 'L' :
				cnt++;
				i += 2;
				break;
			}
		}
		
		bw.write((cnt<n?cnt:n) + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}	
