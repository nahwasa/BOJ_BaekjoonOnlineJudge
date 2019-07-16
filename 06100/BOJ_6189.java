import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dirX = new int[] {1,-1,0,0};
		int[] dirY = new int[] {0,0,1,-1};
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Pos dst = new Pos(0, 0, 0);
		boolean[][] arr = new boolean[N][M];
		Queue<Pos> q = new LinkedList<Pos>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				switch(input.charAt(j)) {
				case 'B' : arr[i][j]=true; q.add(new Pos(i,j, 0)); break;
				case 'C' : dst.x=i; dst.y=j; break;
				case '*' : arr[i][j]=true; break;
				}
			}
		}
		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			if (tmp.x==dst.x && tmp.y==dst.y)
				dst.dis=tmp.dis;
			for (int i = 0; i < 4; i++) {
				int x = tmp.x + dirX[i];
				int y = tmp.y + dirY[i];
				if (x<0||y<0||x>=N||y>=M||arr[x][y]) continue;
				arr[x][y]=true;
				q.add(new Pos(x,y,tmp.dis+1));
			}			
		}
		bw.write(dst.dis+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
class Pos {
	int x,y,dis;
	public Pos(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}	
}
