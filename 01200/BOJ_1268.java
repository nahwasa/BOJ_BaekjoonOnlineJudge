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
		
		if (n == 1) {
			bw.write("1\n");
			return;
		}
		
		int[][] grade = new int[n+1][5];
		boolean[][] dupCheck = new boolean[n+1][n+1];
		int[] cnt = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for (int j = 0; j < 5; j++) {			
				grade[i][j] = Integer.parseInt(st.nextToken());
				
				if (i > 1) {
					for (int k = 1; k < i; k++) {
						if (grade[i][j] == grade[k][j] && !dupCheck[i][k]) {
							cnt[i]++;
							cnt[k]++;
							dupCheck[i][k] = dupCheck[k][i] = true;
						}						
					}
				}
			}					
		}
		
		int result = 1;
		int max = cnt[1];
		for (int i = 2; i <= n; i++) {
			if (cnt[i] > max) {
				result = i;
				max = cnt[i];
			}			
		}
		
		
		bw.write(result + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
