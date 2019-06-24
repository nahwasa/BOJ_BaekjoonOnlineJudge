import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();		
		for (int i = 0; i < N; i++)
			hm.put(i, Integer.parseInt(br.readLine()));
		HashSet<Integer> chk = new HashSet<Integer>();
		int cur = 0;
		chk.add(cur);
		int cnt = 0;
		while (true) {
			int target = hm.get(cur);			
			cnt++;
			if (target == K) {
				bw.write(cnt + "\n");
				break;
			} 
			if (chk.contains(target)) {
				bw.write("-1\n");
				break;
			}
			chk.add(target);
			cur = target;			
		}		
		bw.flush();
		bw.close();
		br.close();
	}	
}
