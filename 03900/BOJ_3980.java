import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			max = Integer.MIN_VALUE;	//initialize
			int[][] arr = new int[11][11];
			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[] v = new boolean[11];
			completeSearch(arr, v, -1, 0);
			bw.write(max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void completeSearch(int[][] arr, boolean[] v, int idx, int sum) {
		if (++idx == 11) {
			max = Math.max(max, sum);
			return;
		}		
		for (int i = 0; i < 11; i++) {
			if (arr[idx][i] != 0 && !v[i]) {
				v[i] = true;
				completeSearch(arr, v, idx, sum+arr[idx][i]);
				v[i] = false;
			}
		}
	}	
}
