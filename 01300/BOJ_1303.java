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
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());		
		boolean[][] arrWhite = new boolean[N][M];
		boolean[][] arrBlue =  new boolean[N][M];
		int whiteCnt = 0;
		int blueCnt = 0;
		int[] dirX = new int[] {1,-1,0,0};
		int[] dirY = new int[] {0,0,1,-1};		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				switch(s.charAt(j)) {
				case 'W' :
					arrWhite[i][j] = true;
					break;
				case 'B' :
					arrBlue[i][j] = true;
					break;
				}
			}
		}		
		for (int team = 0; team < 2; team++) {
			boolean[][] arr = arrWhite;
			if (team == 1) arr = arrBlue;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j]) {
						Queue<Pos> q = new LinkedList<Pos>();
						q.add(new Pos(i, j));
						arr[i][j]=false;
						int cnt = 1;
						while (!q.isEmpty()) {
							Pos tmp = q.poll();
							int x = tmp.x;
							int y = tmp.y;
							for (int k = 0; k < 4; k++) {
								int tmpX = x+dirX[k];
								int tmpY = y+dirY[k];
								if (tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<M && arr[tmpX][tmpY]) {
									cnt++;
									arr[tmpX][tmpY]=false;
									q.add(new Pos(tmpX,tmpY));
								}
							}
						}
						if (team==0) whiteCnt+=cnt*cnt;
						else blueCnt+=cnt*cnt;
					}
				}
			}
		}
		bw.write(String.format("%d %d\n", whiteCnt, blueCnt));
		bw.flush();
		bw.close();
		br.close();
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
