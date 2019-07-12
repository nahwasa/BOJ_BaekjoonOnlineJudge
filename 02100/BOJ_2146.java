import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] v;	// for dfs
	static Pos[][] arr;		// for bfs
	static Queue<Pos> q;	// for bfs
	static int[] dirX = new int[] {1,-1,0,0};
	static int[] dirY = new int[] {0,0,1,-1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		v = new boolean[N][N];
		q = new LinkedList<Pos>();
		arr = new Pos[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 0) 
					v[i][j]=true;
			}
		}
		// search island
		int islandNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) dfs(i, j, islandNum++);
			}
		}		
		// search shortest distance	
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = tmp.x + dirX[i];
				int y = tmp.y + dirY[i];
				if (x<0||x>=N||y<0||y>=N) continue;
				if (arr[x][y]==null) {
					arr[x][y]=new Pos(x,y,tmp.n,tmp.d+1);
					q.add(arr[x][y]);
				} else if (arr[x][y].n==tmp.n) {
					continue;
				} else {
					int distance = tmp.d+arr[x][y].d;
					if (distance<min) min=distance;
				}
			}	
		}
		bw.write(min + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void dfs(int x, int y, int n) {
		v[x][y] = true;
		arr[x][y] = new Pos(x,y,n,0);
		q.add(arr[x][y]);
		for (int i = 0; i < 4; i++) {
			int nx = x + dirX[i];
			int ny = y + dirY[i];
			if (nx<0||nx>=N||ny<0||ny>=N||v[nx][ny]) continue;
			dfs(nx, ny, n);
		}
	}
}

class Pos{
	int x, y, n, d;	//x,y,# of island,distace
	public Pos(int x, int y, int n, int d) {
		this.x = x;
		this.y = y;
		this.n = n;
		this.d = d;
	}
}
