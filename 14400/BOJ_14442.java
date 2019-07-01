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
		int K = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[N+1][M+1][K+1];	// N과 M은 1~N, 1~M까지 사용. K는 0~K까지 사용 / 0:이동가능, 1:벽, -1:지나온곳
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (input.charAt(j-1)=='1') {
					for (int k = 0; k <= K; k++)
						arr[i][j][k]=1;	// 벽이면 모든 k에 대해 벽으로 체크
				}
			}
		}
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(1,1,K,1));
		for (int i = 0; i <= K; i++)	// 시작점은 모든 경우에 다시 못오게.		
			arr[1][1][i] = -1;
		Pos tmp = null;
		boolean isFound = false;
		while (!q.isEmpty()) {
			tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int c = tmp.crash;
			int d = tmp.distance;
			if (x == N && y == M) {	isFound=true; break; }	// 목적지 도착
			// 벽 부수고 이동하는것에 대한 체크. c가 0이면 더이상 부술 수 없으므로 체크하지 않음.
			if (c!=0 && x-1>=1 && arr[x-1][y][c]!=-1 && arr[x-1][y][c]!=0) { arr[x-1][y][c-1]=-1; q.add(new Pos(x-1,y,c-1,d+1)); }
			if (c!=0 && y-1>=1 && arr[x][y-1][c]!=-1 && arr[x][y-1][c]!=0) { arr[x][y-1][c-1]=-1; q.add(new Pos(x,y-1,c-1,d+1)); }
			if (c!=0 && x+1<=N && arr[x+1][y][c]!=-1 && arr[x+1][y][c]!=0) { arr[x+1][y][c-1]=-1; q.add(new Pos(x+1,y,c-1,d+1)); }
			if (c!=0 && y+1<=M && arr[x][y+1][c]!=-1 && arr[x][y+1][c]!=0) { arr[x][y+1][c-1]=-1; q.add(new Pos(x,y+1,c-1,d+1)); }
			// 벽 안부수고 이동하는것에 대한 체크
			if (x-1>=1 && arr[x-1][y][c]==0) { arr[x-1][y][c]=-1; q.add(new Pos(x-1,y,c,d+1)); }
			if (y-1>=1 && arr[x][y-1][c]==0) { arr[x][y-1][c]=-1; q.add(new Pos(x,y-1,c,d+1)); }
			if (x+1<=N && arr[x+1][y][c]==0) { arr[x+1][y][c]=-1; q.add(new Pos(x+1,y,c,d+1)); }
			if (y+1<=M && arr[x][y+1][c]==0) { arr[x][y+1][c]=-1; q.add(new Pos(x,y+1,c,d+1)); }
		}
		if (isFound)
			bw.write(tmp.distance + "\n");
		else
			bw.write("-1\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Pos {
	int x,y,crash,distance;
	public Pos(int x, int y, int crash, int distance) {
		this.x = x;
		this.y = y;
		this.crash = crash;	// 부술수있는 횟수
		this.distance = distance;	// 현재까지 진행거리
	}	
}
