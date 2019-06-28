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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			int case1 = Integer.parseInt(st.nextToken());
			int case2 = Integer.parseInt(st.nextToken());
			arr[case1][case2]=-1;
			arr[case2][case1]=1;
		}
		int cnt = -1;		
		while (cnt!=0) {
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j]!=-1) continue;
					for (int k = 1; k <= N; k++) {
						if (arr[j][k]==-1 && arr[i][k]!=-1) {arr[i][k]=-1; arr[k][i]=1; cnt++;}
					}
				}
			}
		}
		int S = Integer.parseInt(br.readLine());
		while(S-->0) {
			st = new StringTokenizer(br.readLine());
			bw.write(arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
		}
		bw.flush();		
		bw.close();
		br.close();
	}
}
