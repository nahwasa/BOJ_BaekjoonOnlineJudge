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
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
			}
		}		

		int maxCnt = 0, picCnt = 0;
		Queue<Pos> q = new LinkedList<Pos>() {
			@Override
			public boolean add(Pos e) {				
				arr[e.x][e.y] = false;
				return super.add(e);
			}			
		};
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				if (arr[i][j]) q.add(new Pos(i,j));
				else continue;
				picCnt++;
				while (!q.isEmpty()) {					
					Pos tmp = q.poll(); cnt++;
					if (tmp.x>0&&arr[tmp.x-1][tmp.y])   q.add(new Pos(tmp.x-1,tmp.y));
					if (tmp.y>0&&arr[tmp.x][tmp.y-1])   q.add(new Pos(tmp.x,tmp.y-1));
					if (tmp.x<N-1&&arr[tmp.x+1][tmp.y]) q.add(new Pos(tmp.x+1,tmp.y));
					if (tmp.y<M-1&&arr[tmp.x][tmp.y+1]) q.add(new Pos(tmp.x,tmp.y+1));
				}
				if (maxCnt < cnt) {					
					maxCnt = cnt;
				}
			}
		}
		
		bw.write(String.format("%d\n%d\n", picCnt, maxCnt));
		
		bw.flush();		
		bw.close();
		br.close();
	}
}

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {		
		this.x = x;
		this.y = y;
	}
	
}
