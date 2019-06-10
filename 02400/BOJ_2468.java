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
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int maxHeight = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > maxHeight)
					maxHeight = arr[i][j];
			}
		}
		int maxSafeZone = 1;	// 최소 1개는 가능함 (전체가 안잠김)
		for (int h = 1; h < maxHeight; h++) {
			boolean[][] chk = new boolean[N][N];
			Queue<Pos> q = new LinkedList<Pos>();
			int safeZoneTmp = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (arr[i][j] <= h)
						chk[i][j] = true;			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!chk[i][j]) {
						q.add(new Pos(i,j));
						chk[i][j] = true;
						safeZoneTmp++;
						
						while (!q.isEmpty()) {
							Pos p = q.poll();
							int x = p.x;
							int y = p.y;
							if (x>0&&!chk[x-1][y]) {chk[x-1][y]=true; q.add(new Pos(x-1,y));}
							if (y>0&&!chk[x][y-1]) {chk[x][y-1]=true; q.add(new Pos(x,y-1));}
							if (x<N-1&&!chk[x+1][y]) {chk[x+1][y]=true; q.add(new Pos(x+1,y));}
							if (y<N-1&&!chk[x][y+1]) {chk[x][y+1]=true; q.add(new Pos(x,y+1));}						
						}
					}
				}
			}
			if (safeZoneTmp > maxSafeZone)
				maxSafeZone = safeZoneTmp;
		}
		bw.write(maxSafeZone + "\n");
		
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
