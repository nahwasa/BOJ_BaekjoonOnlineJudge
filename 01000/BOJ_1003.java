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
		int[] input = new int[n];		
		int maxInput = 0;
		
		
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (input[i] > maxInput)
				maxInput = input[i];
		}
		
		int[][] tmp = new int[2][maxInput + 1];	// n,k : fibonacci(n)이 k를 부른 횟수 기록(dp)
		tmp[0][0] = 1;
		tmp[1][1] = 1;
		for (int i = 2; i <= maxInput; i++) {
			tmp[0][i] = tmp[0][i-2] + tmp[0][i-1];
			tmp[1][i] = tmp[1][i-2] + tmp[1][i-1];
		}
		
		for (int i = 0; i < n; i++) {
			bw.write(tmp[0][input[i]] + " " + tmp[1][input[i]] + "\n");
		}		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
