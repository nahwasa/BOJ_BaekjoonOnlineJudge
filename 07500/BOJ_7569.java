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
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] arr = new int[N][M][H];
		Queue<Pos> q = new LinkedList<Pos>();
		int remainTmt = 0;
		
		for (int k = 0; k < H; k++) {		
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1)
						q.add(new Pos(i, j, k));
					else if (arr[i][j][k] == 0)
						remainTmt++;
				}
			}
		}
		if (q.isEmpty()) {
			bw.write("-1\n"); 
			bw.flush();		
			bw.close();
			br.close();
			return;
		} else if (remainTmt == 0) {
			bw.write("0\n"); 
			bw.flush();		
			bw.close();
			br.close();
			return;
		}
		int day = -1;
		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int z = tmp.z;
			if (arr[x][y][z] > day)
				day = arr[x][y][z];
			if (x>0&&arr[x-1][y][z]==0) {remainTmt--; q.add(new Pos(x-1, y, z)); arr[x-1][y][z]=arr[x][y][z]+1;}
			if (y>0&&arr[x][y-1][z]==0) {remainTmt--; q.add(new Pos(x, y-1, z)); arr[x][y-1][z]=arr[x][y][z]+1;}
			if (z>0&&arr[x][y][z-1]==0) {remainTmt--; q.add(new Pos(x, y, z-1)); arr[x][y][z-1]=arr[x][y][z]+1;}
			if (x<N-1&&arr[x+1][y][z]==0) {remainTmt--; q.add(new Pos(x+1, y, z)); arr[x+1][y][z]=arr[x][y][z]+1;}
			if (y<M-1&&arr[x][y+1][z]==0) {remainTmt--; q.add(new Pos(x, y+1, z)); arr[x][y+1][z]=arr[x][y][z]+1;}
			if (z<H-1&&arr[x][y][z+1]==0) {remainTmt--; q.add(new Pos(x, y, z+1)); arr[x][y][z+1]=arr[x][y][z]+1;}
		}		
		if (remainTmt!=0) {
			bw.write("-1\n"); 
			bw.flush();		
			bw.close();
			br.close();
			return;
		}
		bw.write((day-1)+"\n");
		bw.flush();		
		bw.close();
		br.close();
	}
}

class Pos {
	int x;
	int y;
	int z;
	public Pos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
