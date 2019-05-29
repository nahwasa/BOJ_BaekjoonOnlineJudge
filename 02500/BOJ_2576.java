import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 7; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n % 2 != 0) {
				sum += n;
				
				if (min > n)
					min = n;
			}
		}
		if ( sum != 0 ) {
			bw.write(sum + "\n");
			bw.write(min + "\n");
		} else {
			bw.write("-1\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
