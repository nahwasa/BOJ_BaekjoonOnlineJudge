import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		HashSet<Integer> hs = new HashSet<Integer>();	// 멀티탭
		int[] arr = new int[K];
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(st.nextToken());		
		for (int i = 0; i < K; i++) {
			int tmp = arr[i];
			if (hs.contains(tmp)) continue;	// 이미 꽂힌거라면 걍 쓰면됨
			if (!hs.contains(tmp) && hs.size() < N) {hs.add(tmp); continue;}	// 구멍 충분하면 걍 꽂으면 됨
			// 이하 특정 콘센트를 빼야함.
			Iterator<Integer> it = hs.iterator();
			int max = 0;
			int maxNum = 0;
			while (it.hasNext()) {	// 꽂혀있던 각 콘센트에 대해
				int cur = it.next();
				int j = i+1;
				for (; j < K; j++) {
					if (arr[j] == cur)
						break;
				}
				if (j > max) {
					max = j;
					maxNum = cur;
				}
			}
			hs.remove(maxNum);	// 가장 뒤에 사용되는 콘센트를 뺌.(앞으로 아예 안쓰이면 j가 K가 되므로 가장 크므로 우선순위가 가장 높음)
			cnt++;
			hs.add(tmp);
		}		
		bw.write(cnt+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
