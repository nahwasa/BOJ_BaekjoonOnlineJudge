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
		int result = 1;
		
		for (int i = n; i >= 1; i--) {
			result *= i;
		}
		bw.write(result + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
