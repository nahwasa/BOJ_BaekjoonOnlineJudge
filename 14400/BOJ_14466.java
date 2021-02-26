import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] block;
	private static boolean[][] v;
	private static boolean[][] cow;
	private static int[] groupCnt;
	private static int N;
	private static int pairCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		v = new boolean[N+1][N+1];
		block = new boolean[10001][10001];
		cow = new boolean[N+1][N+1];
		groupCnt = new int[N*N];
		
		while (r-->0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int hash1 = (r1-1)*N + c1;
			int hash2 = (r2-1)*N + c2;
			block[hash1][hash2] = true;
			block[hash2][hash1] = true;
		}
		
		while (k-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cow[x][y] = true;
		}
		
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (v[i][j])
					continue;
				groupCnt[idx++] = bfs(new Pos(i, j));
				
			}
		}
		
		for (int i = 0; i < idx-1; i++) {
			for (int j = i+1; j < idx; j++) {
				pairCnt += groupCnt[i] * groupCnt[j];
			}
		}
		
		bw.write(pairCnt + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

	
	private static boolean isVisited(Pos pos) {
		return v[pos.x][pos.y];
	}
	
	private static void setVisited(Pos pos) {
		v[pos.x][pos.y] = true; 
	}
	
	private static boolean isBlocked(Pos p1, Pos p2) {
		return block[(p1.x-1)*N+p1.y][(p2.x-1)*N+p2.y];
	}
	
	private static boolean isOutOfMap(Pos pos) {
		int x = pos.x;
		int y = pos.y;
		if (x < 1 || y < 1 || x > N || y > N)
			return true;
		return false;
	}
	
	private static boolean isCow(Pos pos) {
		return cow[pos.x][pos.y];
	}
	
	private static int bfs(Pos startPos) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(startPos);
		setVisited(startPos);
		int cowCnt = 0;
		
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			if (isCow(pos))
				cowCnt++;

			for (int i = 0; i < 4; i++) {
				Pos nextPos = Pos.getNextPos(pos, i);
				if (isOutOfMap(nextPos) || isVisited(nextPos) || isBlocked(pos, nextPos))
					continue;
				setVisited(nextPos);
				q.add(nextPos);
			}
		}
		
		return cowCnt;
	}
}

class Pos {
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	int x, y;

	public static Pos getNextPos(Pos from, int dir) {
		return new Pos(from.x + dx[dir], from.y + dy[dir]);
	}
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
