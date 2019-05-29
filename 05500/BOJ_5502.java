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
		StringBuilder input = new StringBuilder(br.readLine());
		String s1 = "0" + input.toString();
		String s2 = "0" + input.reverse().toString();
		int[][] lcs = new int[n+1][n+1];
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (s1.charAt(i) == s2.charAt(j))
					lcs[i][j] = lcs[i-1][j-1]+1;
				else 
					lcs[i][j] = lcs[i-1][j] > lcs[i][j-1] ? lcs[i-1][j] : lcs[i][j-1];
			}
		}
		
		bw.write((n - lcs[n][n]) + "\n");				
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
