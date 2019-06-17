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
			if (s.equals("0 0"))
				break;
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
						Queue<Pos> q = new LinkedList<Pos>();
						q.add(new Pos(i, j));
						map[i][j] = false;
						
						while (!q.isEmpty()) {
							Pos tmp = q.poll();
							int x = tmp.x;
							int y = tmp.y;
							if (x>0&&map[x-1][y]) {map[x-1][y]=false; q.add(new Pos(x-1,y));}
							if (y>0&&map[x][y-1]) {map[x][y-1]=false; q.add(new Pos(x,y-1));}
							if (x<N-1&&map[x+1][y]) {map[x+1][y]=false; q.add(new Pos(x+1,y));}
							if (y<M-1&&map[x][y+1]) {map[x][y+1]=false; q.add(new Pos(x,y+1));}
							if (x>0&&y>0&&map[x-1][y-1]) {map[x-1][y-1]=false; q.add(new Pos(x-1,y-1));}
							if (x>0&&y<M-1&&map[x-1][y+1]) {map[x-1][y+1]=false; q.add(new Pos(x-1,y+1));}
							if (x<N-1&&y>0&&map[x+1][y-1]) {map[x+1][y-1]=false; q.add(new Pos(x+1,y-1));}
							if (x<N-1&&y<M-1&&map[x+1][y+1]) {map[x+1][y+1]=false; q.add(new Pos(x+1,y+1));}
						}
					}
				}
			}
			bw.write(cnt+"\n");
		}
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
