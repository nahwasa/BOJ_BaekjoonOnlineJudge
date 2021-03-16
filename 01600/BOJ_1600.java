import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[] hdx = {1, 1, 2, 2, -1, -1, -2, -2};
	static int[] hdy = {2, -2, 1, -1, 2, -2, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int destW = w-1;
		int destH = h-1;
		boolean[][][] v = new boolean[k+1][h][w];
		boolean[][] block = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++)
				block[i][j] = st.nextToken().equals("1") ? true : false;
		}
		br.close();
		
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(0, 0, k, 0));
		v[k][0][0] = true;
		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			if (tmp.w == destW && tmp.h == destH) {
				System.out.println(tmp.cnt);
				return;
			}
			
			if (tmp.k > 0) {
				for (int i = 0; i < 8; i++) {
					int x = tmp.w + hdx[i];
					int y = tmp.h + hdy[i];
					if (x < 0 || y < 0 || x > destW || y > destH || v[tmp.k-1][y][x] || block[y][x])
						continue;
					v[tmp.k-1][y][x] = true;
					q.add(new Pos(y, x, tmp.k-1, tmp.cnt+1));
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int x = tmp.w + dx[i];
				int y = tmp.h + dy[i];
				if (x < 0 || y < 0 || x > destW || y > destH || v[tmp.k][y][x] || block[y][x])
					continue;
				v[tmp.k][y][x] = true;
				q.add(new Pos(y, x, tmp.k, tmp.cnt+1));
			}
			
		}
		System.out.println(-1);
	}
}

class Pos {
	int h, w, k, cnt;
	public Pos(int h, int w, int k, int cnt) {
		this.h = h;
		this.w = w;
		this.k = k;
		this.cnt = cnt;
	}
}
