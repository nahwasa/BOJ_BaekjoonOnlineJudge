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
		int[] calc = new int[n + 1];
		
		calc[1] = 5;
		
		for(int i = 2; i <= n; i++) {
			calc[i] = ( calc[i-1] + 4 + 3 * (i-1)) % 45678 ;
		}
		
		bw.write(calc[n] + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
