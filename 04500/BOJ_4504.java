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
		
		while (true) {
			int d = Integer.parseInt(br.readLine());
			if (d == 0)
				break;
			
			if (d % n == 0) {			
				bw.write(d + " is a multiple of " + n + ".\n");
			} else {
				bw.write(d + " is NOT a multiple of " + n + ".\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
