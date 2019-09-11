import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	final static int[] dx = new int[] {-1,0,0,1};
	final static int[] dy = new int[] {0,-1,1,0};
	static char[][] arr;
	static boolean[] v = new boolean[26];
	static int N, M;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// initialize
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		// input
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		// dfs
		v[arr[0][0]-'A'] = true;
		dfs(0, 0, 1);
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	

	private static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);
		for (int d = 0; d < 4; d++) {
			int rx = x + dx[d];
			int ry = y + dy[d];
			if (rx<0||rx>=N||ry<0||ry>=M||v[arr[rx][ry]-'A'])
				continue;
			v[arr[rx][ry]-'A'] = true;
			dfs(rx,ry,cnt+1);
			v[arr[rx][ry]-'A'] = false;
		}
	}	
}
