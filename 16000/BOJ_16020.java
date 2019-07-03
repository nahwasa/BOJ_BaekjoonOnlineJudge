import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int dir = 0;
		int[][] arr = new int[N][N];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if 		(i==0&&j==0&&arr[i][j]<min) 	{ dir=0; min = arr[i][j]; }
				else if (i==0&&j==N-1&&arr[i][j]<min) 	{ dir=1; min = arr[i][j]; }
				else if (i==N-1&&j==N-1&&arr[i][j]<min) 	{ dir=2; min = arr[i][j]; }
				else if (i==N-1&&j==0&&arr[i][j]<min) { dir=3; min = arr[i][j]; }
			}
		}
		switch (dir) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bw.write(arr[i][j] + (j!=N-1?" ":""));
				}
				bw.newLine();
			}
			break;
		case 1:
			for (int i = N-1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					bw.write(arr[j][i] + (j!=N-1?" ":""));
				}
				bw.newLine();
			}
			break;
		case 2:
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-1; j >= 0; j--) {
					bw.write(arr[i][j] + (j!=0?" ":""));
				}
				bw.newLine();
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) {
					bw.write(arr[j][i] + (j!=0?" ":""));
				}
				bw.newLine();
			}
			break;
		}		
		bw.flush();
		br.close();
		bw.close();		
	}
}
