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
		int idx = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i)-s.charAt(i-1) == 1)
				idx++;
			else { 
				if (idx==2) {cnt++; idx=0;}
				else idx=0;
			}			
		}
		if (idx==2) cnt++;
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
