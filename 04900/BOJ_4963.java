import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine();
			if (s.equals("0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					if (st.nextToken().charAt(0) == '1') 
						map[i][j] = true;
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]) {
						cnt++;
						bfs(map, i, j);
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(boolean[][] map, int i, int j) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(i, j));
		map[i][j] = false;
		
		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {
					int rx=x+dx;
					int ry=y+dy;
					if (rx<0||rx>=map.length||ry<0||ry>=map[0].length||!map[rx][ry])
						continue;
					map[rx][ry]=false;
					q.add(new Pos(rx, ry));
				}
			}
		}
	}
}

class Pos {
	int x,y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
