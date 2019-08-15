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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] time = new int[N+1];
			int[] inDegree = new int[N+1];
			LinkedList<Integer>[] arr = new LinkedList[N+1];
			int[] mm = new int[N+1];
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				arr[i] = new LinkedList<Integer>();
			}
			while (K-->0) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
				inDegree[to]++;
			}
			int W = Integer.parseInt(br.readLine());
			Queue<Pos> q = new LinkedList<Pos>();
			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) {
					q.add(new Pos(i, time[i]));
					mm[i] = time[i];
				}
			}
			while (!q.isEmpty()) {
				Pos tmp = q.poll();				
				for (int to : arr[tmp.n]) {				
					mm[to] = mm[to]>tmp.time+time[to]?mm[to]:tmp.time+time[to];
					if (--inDegree[to] == 0) {
						q.add(new Pos(to, mm[to]));
					}					
				}				
			}
			bw.write(mm[W] + "\n");			
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}

class Pos {
	int n, time;
	public Pos(int n, int time) {
		this.n = n;
		this.time = time;
	}
	
}
