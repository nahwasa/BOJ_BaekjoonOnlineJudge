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
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] chk = new boolean[100001];
		int[] dist = new int[100001];		
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		chk[N] = true;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == K) {
				bw.write(dist[K]+"\n");
				break;
			}
			
			if (tmp>0&&!chk[tmp-1]) 			 { chk[tmp-1]=true; dist[tmp-1]=dist[tmp]+1; q.add(tmp-1); }
			if (tmp<chk.length-1&&!chk[tmp+1])	 { chk[tmp+1]=true; dist[tmp+1]=dist[tmp]+1; q.add(tmp+1); }
			if (tmp*2<chk.length&&!chk[tmp*2])	 { chk[tmp*2]=true; dist[tmp*2]=dist[tmp]+1; q.add(tmp*2); }
		}		
			
		bw.flush();		
		bw.close();
		br.close();
	}
}
