import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {	
	private static Map<Integer, HashMap<Integer, Integer>> edge;
	private static int v, farthestV;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		edge = new HashMap<>();

		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			edge.put(from, new HashMap<>());
			while (st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)	break;
				int dist = Integer.parseInt(st.nextToken());
				edge.get(from).put(to, dist);
			}
		}
		
		farthestV = 1;
		dfs(1, 0, new boolean[v+1]);
		dfs(farthestV, 0, new boolean[v+1]);
		
		System.out.println(max);
		br.close();
	}
	
	private static void dfs(int s, int sum, boolean[] visit) {
		visit[s] = true;
		HashMap<Integer, Integer> tmp = edge.get(s);
		if (sum > max) {
			max = sum;
			farthestV = s;
		}
		for (Integer i : tmp.keySet()) {
			if (visit[i]) continue;
			dfs(i, sum + tmp.get(i), visit);
		}
	}
}	
