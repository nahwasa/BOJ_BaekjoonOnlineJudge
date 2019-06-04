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
		for (int i = 0; i < n; i++) {
			int aSum = 0;
			double sum = 0;
			int k = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				double b = Double.parseDouble(st.nextToken());
				
				aSum += a;
				sum += (a*b);
			}
			System.out.printf("%d %.1f\n", aSum, sum/aSum);
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
