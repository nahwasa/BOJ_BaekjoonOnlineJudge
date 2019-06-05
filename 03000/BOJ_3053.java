import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	static int k = 0;
	static int cnt = 0;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		bw.write(String.format("%.6f\n", Math.PI * n * n));
		bw.write(String.format("%.6f\n", 2.0 * n * n));
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}
