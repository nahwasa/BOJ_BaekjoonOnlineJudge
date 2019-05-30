import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			String in = br.readLine();
			for (int j = 0; j < 8; j++) {
				if (j%2 == (i%2==0?0:1) && in.charAt(j)=='F')
					cnt++;
			}
		}
		bw.write(cnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
