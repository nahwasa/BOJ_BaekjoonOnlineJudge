import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int SOURCE = 1;
    private static final int SINK = 2;
    int[][] capacity, flow;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        capacity = new int[n+1][n+1];
        flow = new int[n+1][n+1];
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (p-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            capacity[a][b] = 1;
            edges[a].add(b);
            edges[b].add(a);
        }

        long cnt = 0;
        while (true) {
            int[] parent = new int[n+1];
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            parent[SOURCE] = SOURCE;
            q.add(SOURCE);

            while (!q.isEmpty() && parent[SINK] == -1) {
                int cur = q.poll();
                for (int next : edges[cur]) {
                    if (capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = cur;
                    }
                }
            }
            if (parent[SINK] == -1)
                break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = SINK; i != SOURCE; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            for (int i = SINK; i != SOURCE; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            cnt += minFlow;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
