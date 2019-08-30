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
		boolean[][] arr = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'L')
					arr[i][j] = true;
			}
		}
		int[] dx = new int[] {-1,0,0,1};
		int[] dy = new int[] {0,-1,1,0};
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {				
				if (arr[i][j]) {
					boolean[][] v = new boolean[N][M];
					Queue<Pos> q = new LinkedList<Pos>();
					v[i][j] = true;
					q.add(new Pos(i,j,0));
					while (!q.isEmpty()) {
						Pos tmp = q.poll();
						max = Math.max(max, tmp.d);					
						for (int k = 0; k < 4; k++) {
							int rx = tmp.x + dx[k];
							int ry = tmp.y + dy[k];
							if (rx<0||rx>=N||ry<0||ry>=M||v[rx][ry]||!arr[rx][ry])
								continue;
							v[rx][ry] = true;
							q.add(new Pos(rx,ry,tmp.d+1));							
						}
					}
				}				
			}
		}
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();	
	}
}

class Pos {
	int x,y,d;

	public Pos(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}	
}
