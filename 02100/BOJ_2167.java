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
		int[][] arr = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) 
						+ arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1];
			}
		}
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			st = new StringTokenizer(br.readLine());
			int[] pos = new int[] {
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			};
			int result = arr[pos[2]][pos[3]] - arr[pos[0]-1][pos[3]] - arr[pos[2]][pos[1]-1] + arr[pos[0]-1][pos[1]-1];
			bw.write(result + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
