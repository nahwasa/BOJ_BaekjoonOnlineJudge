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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) 
				if (s.charAt(j) == '#')
					arr[i][j] = true;			
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j]) {
					cnt++;
					Queue<Pos> q = new LinkedList<Pos>();
					q.add(new Pos(i, j));
					arr[i][j] = false;
					while (!q.isEmpty()) {
						Pos tmp = q.poll();
						for (int x = -1; x <= 1; x++) {
							for (int y = -1; y <= 1; y++) {
								int dx = tmp.x+x;
								int dy = tmp.y+y;
								if (dx < 0 || dx >= N || dy < 0 || dy >= M || !arr[dx][dy])
									continue;							
								arr[dx][dy] = false;
								q.add(new Pos(dx, dy));								
							}
						}
					}
				}
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}

class Pos {
	int x,y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}
