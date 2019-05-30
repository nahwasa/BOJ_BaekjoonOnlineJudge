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
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			double result = rangeMult(left+1, right) / rangeMult(right-left) + Math.pow(10, -9);
			bw.write((long)result + "\n");
		}
				
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static double rangeMult(int upper) {		
		return rangeMult(2, upper);
	}
	
	private static double rangeMult(int lower, int upper) {
		double result = 1;
		for (int i = lower; i <= upper; i++)
			result *= i;
		return result;
	}
}
