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
		
		for (int i = 0; i < n; i++) {
			for (int x = n - i - 1; x > 0; x--) {
				bw.write(" ");
			}
			
			if (i == 0) {
				bw.write("*\n");
				continue;
			}
			
			bw.write("*");
			for (int x = 0; x < 2*i - 1; x++) {
				if (i == n-1)
					bw.write("*");
				else
					bw.write(" ");
			}

			bw.write("*\n");
		}
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
