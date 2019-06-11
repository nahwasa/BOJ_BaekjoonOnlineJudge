import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		boolean[][] arr = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = true;
		}
		// DFS
		Stack<Integer> stk = new Stack<Integer>();
		boolean[] chk = new boolean[N+1];
		stk.push(V);
		chk[V] = true;
		bw.write(V + " ");
		while (!stk.isEmpty()) {
			int tmp = stk.pop();
			if (!chk[tmp])
				bw.write(tmp + " ");
			chk[tmp] = true;			
			for (int i = N; i >= 1; i--) {
				if (arr[tmp][i] && !chk[i]) {					
					stk.push(i);
					
				}					
			}
		}
		bw.newLine();
		
		
		// BFS
		Queue<Integer> q = new LinkedList<Integer>();
		chk = new boolean[N+1];
		q.add(V);
		chk[V] = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			bw.write(tmp + " ");
			for (int i = 1; i <= N; i++) {
				if (arr[tmp][i] && !chk[i]) {
					chk[i] = true;
					q.add(i);
				}					
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
