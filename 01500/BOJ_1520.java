import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	final static int[] dx = new int[] {-1,0,0,1};
	final static int[] dy = new int[] {0,-1,1,0};
	static int[][] arr, dp;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// initialize
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		// dfs + dp
		bw.write(dfs(0, 0) + "\n");
		// test
//		for (int i = 0; i < N; i++) {			
//			for (int j = 0; j < M; j++) {
//				bw.write(dp[i][j] + " ");
//			}
//			bw.newLine();
//		}
		bw.flush();
		bw.close();
		br.close();
	}	

	private static int dfs(int x, int y) {
		if (x == N-1 && y == M-1)
			return 1;
		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
		for (int dir = 0; dir < 4; dir++) {
			int rx = x + dx[dir];
			int ry = y + dy[dir];
			if (rx<0||rx>=N||ry<0||ry>=M||arr[rx][ry]>=arr[x][y])
				continue;
			dp[x][y] += dfs(rx, ry);			
		}
		return dp[x][y];
	}	
}
