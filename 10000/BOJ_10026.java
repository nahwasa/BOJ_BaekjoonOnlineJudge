import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr1 = new int[N][N];	// R:1, G:2, B:3
		int[][] arr2 = new int[N][N];	// RG:1, B:3
 		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				int stat = 0;
				switch (s.charAt(j)) {
				case 'R' :
					stat = 1;
					break;
				case 'G' :
					stat = 2;
					break;
				case 'B' :
					stat = 3;
					break;
				}
				arr1[i][j] = stat;
				arr2[i][j] = stat<=2?1:stat;
			}
		}
 		
 		// Normal
 		int cnt = 0;
 		for (int i = 0; i < N; i++) {
 			for (int j = 0; j < N; j++) {
 				if (arr1[i][j] != 0) {
 					cnt++;
 					int color = arr1[i][j];
 					Queue<Pos> q = new LinkedList<Pos>();
 					q.add(new Pos(i,j));
 					arr1[i][j] = 0;
 					while (!q.isEmpty()) {
 						Pos tmp = q.poll();
 						int x = tmp.x;
 						int y = tmp.y;
 						if (x>0&&arr1[x-1][y]==color) {arr1[x-1][y]=0; q.add(new Pos(x-1, y));}
 						if (y>0&&arr1[x][y-1]==color) {arr1[x][y-1]=0; q.add(new Pos(x, y-1));}
 						if (x<N-1&&arr1[x+1][y]==color) {arr1[x+1][y]=0; q.add(new Pos(x+1, y));}
 						if (y<N-1&&arr1[x][y+1]==color) {arr1[x][y+1]=0; q.add(new Pos(x, y+1));}
 					}
 				}
 			}
 		}
 		bw.write(cnt + "\n");
 				
 		
 		// Color weekness
 		cnt = 0;
 		for (int i = 0; i < N; i++) {
 			for (int j = 0; j < N; j++) {
 				if (arr2[i][j] != 0) {
 					cnt++;
 					int color = arr2[i][j];
 					Queue<Pos> q = new LinkedList<Pos>();
 					q.add(new Pos(i,j));
 					arr2[i][j] = 0;
 					while (!q.isEmpty()) {
 						Pos tmp = q.poll();
 						int x = tmp.x;
 						int y = tmp.y;
 						if (x>0&&arr2[x-1][y]==color) {arr2[x-1][y]=0; q.add(new Pos(x-1, y));}
 						if (y>0&&arr2[x][y-1]==color) {arr2[x][y-1]=0; q.add(new Pos(x, y-1));}
 						if (x<N-1&&arr2[x+1][y]==color) {arr2[x+1][y]=0; q.add(new Pos(x+1, y));}
 						if (y<N-1&&arr2[x][y+1]==color) {arr2[x][y+1]=0; q.add(new Pos(x, y+1));}
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
	int x;
	int y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
