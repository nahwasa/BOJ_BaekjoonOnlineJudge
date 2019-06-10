import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
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
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while(true) {
			year++;
			LinkedList<Pos> water = new LinkedList<Pos>();
			for (int i = 0; i < N; i++) {	// 물인부분 뽑아냄
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0)
						water.add(new Pos(i, j));
				}
			}
			if (water.size() == N*M) {	// 2덩어리 이상으로 break되지 않았고, 전체가 물이 됬다면 다 녹을때까지 분리가 안된거임.
				bw.write("0\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
			for (Pos p : water) {	// 물 주변 -1
				int x = p.x;
				int y = p.y;
				if (x>0&&arr[x-1][y]>0) arr[x-1][y]--;
				if (y>0&&arr[x][y-1]>0) arr[x][y-1]--;
				if (x<N-1&&arr[x+1][y]>0) arr[x+1][y]--;
				if (y<M-1&&arr[x][y+1]>0) arr[x][y+1]--;
			}
			boolean[][] chk = new boolean[N][M];
			for (int i = 0; i < N; i++) {	// 얼음덩어리 갯수 세기
				for (int j = 0; j < M; j++) {
					if (arr[i][j]==0)
						chk[i][j] = true;
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {	// 얼음덩어리 갯수 세기
				for (int j = 0; j < M; j++) {
					if (!chk[i][j]) {
						cnt++;
						Queue<Pos> q = new LinkedList<Pos>();
						q.add(new Pos(i, j));
						chk[i][j] = true;
						while (!q.isEmpty()) {
							Pos tmp = q.poll();
							int x = tmp.x;
							int y = tmp.y;
							if (x>0&&!chk[x-1][y]) {chk[x-1][y]=true; q.add(new Pos(x-1,y));}
							if (y>0&&!chk[x][y-1]) {chk[x][y-1]=true; q.add(new Pos(x,y-1));}
							if (x<N-1&&!chk[x+1][y]) {chk[x+1][y]=true; q.add(new Pos(x+1,y));}
							if (y<M-1&&!chk[x][y+1]) {chk[x][y+1]=true; q.add(new Pos(x,y+1));}
						}
					}
				}
			}
			if (cnt >= 2) {
				break;
			}
		}
		bw.write(year+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
