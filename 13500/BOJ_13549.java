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
		int[] arr = new int[200001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		arr[N] = 1;
		int time = -1;
		while(!q.isEmpty()) {
			int tmp = q.poll();
						if (tmp == K) {
				time = arr[tmp];
				break;
			}
			if (tmp > 0) {
				int mul = 2;
				while (tmp*mul <= K*2) {
					if (arr[tmp*mul] == 0) {
						arr[tmp*mul] = arr[tmp];
						q.add(tmp*mul);
					}
					mul *= 2;
				}
			}
			if (tmp>0&&arr[tmp-1]==0) { arr[tmp-1]=arr[tmp]+1; q.add(tmp-1); }
			if (tmp<200000&&arr[tmp+1]==0) { arr[tmp+1]=arr[tmp]+1; q.add(tmp+1); }
		}
		bw.write((time-1)+"\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
