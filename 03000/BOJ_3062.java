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
		while(TC-->0) {
			StringBuilder in = new StringBuilder(br.readLine());
			int n = Integer.parseInt(in.toString()) + Integer.parseInt(in.reverse().toString());
			int revN = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());			
			if (n == revN)
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}	
}
