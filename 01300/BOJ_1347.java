import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		boolean[][] map = new boolean[N*2+1][N*2+1];
		map[N][N] = true;	// 시작점
		int x, y, x1, x2, y1, y2;
		x = y = x1 = x2 = y1 = y2 = N;
		int dr = 1;	//0:동, 1:남, 2:서, 3:북
		for (int i = 0; i < N; i++) {
			switch(S.charAt(i)) {
			case 'F' :
				if (dr == 0) {map[x][y+1]=true; y2 = y+1>y2?y+1:y2; y++;}
				else if (dr == 2) {map[x][y-1]=true; y1 = y-1<y1?y-1:y1; y--;}
				else if (dr == 1) {map[x+1][y]=true; x2 = x+1>x2?x+1:x2; x++;}
				else if (dr == 3) {map[x-1][y]=true; x1 = x-1<x1?x-1:x1; x--;}
				break;
			case 'R' :
				dr++;
				if (dr==4) dr=0;
				break;
			case 'L' :
				dr--;
				if (dr==-1) dr=3;
				break;
			}		
		}
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				bw.write(map[i][j]?".":"#");
			}
			bw.newLine();			
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
