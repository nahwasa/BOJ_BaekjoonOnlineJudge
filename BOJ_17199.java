import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[N+1][N+1];
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
		}
		for (int i = 1; i <= N; i++) {
			boolean[] chk = new boolean[N+1];
			Queue<Integer> q = new LinkedList<Integer>();
			int base = i;
			q.add(base);
			chk[base] = true;
			while(!q.isEmpty()) {
				int n = q.poll();
				arr[base][n] = true;
				for (int z = 1; z <= N; z++) {
					if (!chk[z] && arr[n][z]) {
						q.add(z);
						chk[z] = true;
					}
				}
				
			}
		}
		
		boolean chk = true;
		for (int i = 1; i <= N; i++) {
			chk = true;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (!arr[j][i]) {
					chk = false;
					break;
				}
			}
			if (chk) {
				bw.write(i + "\n");
				break;
			}				
		}
		if (!chk) 
			bw.write("-1\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}
