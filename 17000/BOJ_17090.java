import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int[][] map;
	private static Boolean[][] v;
	private static int N, M;
	
	private static int getDirAsInt(char dir) {
		switch (dir) {
		case 'R' :	return 0;
		case 'L' :	return 1;
		case 'D' : 	return 2;
		case 'U' : 	return 3;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//init
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new Boolean[N][M];	// null:not yet visited, true:can escape, false:can't escape
		// input
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = getDirAsInt(row[j]);
			}
		}
		// dfs
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(i, j))
					cnt++;
			}
		}
		bw.write(cnt + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static boolean dfs(int r, int c) {
		if (v[r][c] != null)
			return v[r][c];
		int rx = r+dy[map[r][c]];
		int ry = c+dx[map[r][c]];
		if (rx<0 || rx>=N || ry<0 || ry>=M)
			return true;
		
		v[r][c] = false;
		v[r][c] = dfs(rx, ry);
		return v[r][c];
	}
}
