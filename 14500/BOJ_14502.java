import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
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
		Pos[] path = new Pos[N*M];
		LinkedList<Pos> ll = new LinkedList<Pos>();
		int pathCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				switch(st.nextToken().charAt(0)) {
				case '0' : arr[i][j]=true; path[pathCnt++]=new Pos(i,j); break;
				case '2' : ll.add(new Pos(i,j));
				}
			}
		}
		int maxSafeCnt = 0;
		for (int i = 0; i < pathCnt; i++) {
			for (int j = i+1; j < pathCnt; j++) {
				for (int k = j+1; k < pathCnt; k++) {
					// 배열 copy
					boolean[][] v = new boolean[N][M];
					for (int x=0; x<N; x++)
						for (int y=0; y<M; y++)
							v[x][y]=arr[x][y];
					// 벽 3개 놓기 (모든경우)
					v[path[i].x][path[i].y]=false;
					v[path[j].x][path[j].y]=false; 
					v[path[k].x][path[k].y]=false;					
					Queue<Pos> q = new LinkedList<Pos>();
					Iterator<Pos> it = ll.iterator();
					while (it.hasNext())
						q.add(it.next());
					int safeCnt=pathCnt-3;
					while (!q.isEmpty()) {
						if (safeCnt<=maxSafeCnt)
							break;
						Pos tmp = q.poll();
						int x = tmp.x;
						int y = tmp.y;
						if (x>0&&v[x-1][y]) { safeCnt--; v[x-1][y]=false; q.add(new Pos(x-1,y)); }
						if (y>0&&v[x][y-1]) { safeCnt--; v[x][y-1]=false; q.add(new Pos(x,y-1)); }
						if (x<N-1&&v[x+1][y]) { safeCnt--; v[x+1][y]=false; q.add(new Pos(x+1,y)); }
						if (y<M-1&&v[x][y+1]) { safeCnt--; v[x][y+1]=false; q.add(new Pos(x,y+1)); }
					}
					if (safeCnt > maxSafeCnt) maxSafeCnt=safeCnt;
				}
			}
		}
		bw.write(maxSafeCnt + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}

class Pos {
	int x, y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}	
}
