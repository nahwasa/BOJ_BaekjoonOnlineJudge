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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		int max = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < M-1; j++) {
				int min = N-i<M-j?N-i:M-j;				
				for (int a = 1; a < min; a++)
					if (arr[i][j]==arr[i+a][j]&&arr[i][j]==arr[i][j+a]&&arr[i][j]==arr[i+a][j+a]) max=a>max?a:max;
			}
		}
		bw.write(String.valueOf((max+1)*(max+1)) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
