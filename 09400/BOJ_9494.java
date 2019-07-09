import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if (N==0)
				break;
			int idx = 0;
			while(N-->0) {
				String s = br.readLine();
				if (idx > s.length()-1) continue;
				for(; idx < s.length(); idx++)
					if(s.charAt(idx)==' ') break;				
			}
			bw.write((idx+1)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
