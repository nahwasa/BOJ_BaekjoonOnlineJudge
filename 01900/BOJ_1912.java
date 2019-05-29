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
		int[] in = new int[n];		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {			
			in[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = in[0];
		for (int i = 1; i < n; i++) {			
			if (in[i-1] > 0) {
				int sum = in[i-1] + in[i];
				if (sum > 0)
					in[i] = sum;				
			}
			if (in[i] > max)
				max = in[i];
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
