import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		if (n == 1) {
			int input = Integer.parseInt(st.nextToken());
			bw.write((long)input * input + "\n");
			bw.flush();
			br.close();
			bw.close();	
			return;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			if (input < min)
				min = input;
			if (input > max)
				max = input;
		}
		
		long result = (long)min * max;
		bw.write(result + "\n");
	
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
