import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			while (N-->0) hm.put(br.readLine(), 0);
			while (M-->0) {
				st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				int vote = Integer.parseInt(st.nextToken());
				hm.replace(tmp, hm.get(tmp)+vote);
			}
			int max = -1;
			int maxCnt = 0;
			String maxName = "";
			for(String name:hm.keySet()) {
				int v = hm.get(name);
				if (v>max) {
					max=v;
					maxName=name;
					maxCnt=1;
					continue;
				} 
				if (v==max) {
					maxCnt++;
				}
			}
			if (maxCnt>1) bw.write(String.format("VOTE %d: THERE IS A DILEMMA\n", tc));
			else 		  bw.write(String.format("VOTE %d: THE WINNER IS %s %d\n", tc, maxName, max));			
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
