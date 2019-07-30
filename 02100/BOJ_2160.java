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
		boolean[][][] arr = new boolean[5][7][N];
		for (int i = 0; i < N; i++) {
			for (int x = 0; x < 5; x++) {
				String s = br.readLine();
				for (int y = 0; y < 7; y++) {
					arr[x][y][i] = s.charAt(y)=='X'?true:false;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				int cnt = 0;
				for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 7; y++) {
						if (arr[x][y][i]!=arr[x][y][j])
							cnt++;
					}
				}
				if (cnt < min) {
					min = cnt;
					res[0] = i+1;
					res[1] = j+1;
				}
			}
		}
		bw.write(res[0]+" "+res[1]+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
