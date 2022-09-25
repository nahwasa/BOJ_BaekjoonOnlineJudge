import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int SOURCE = 'A'-'A';
    private static final int SINK = 'Z'-'A';
    private static final int A_TO_Z = 'Z'-'A'+1;
    private static final int LIMIT_OF_IDX = ('Z'-'A'+1)*2;

    private int charToIdx(char c) {
        if (c <= 'Z') return c-'A';
        return c-'a'+A_TO_Z;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] capacity = new int[LIMIT_OF_IDX][LIMIT_OF_IDX];
        int[][] flow = new int[LIMIT_OF_IDX][LIMIT_OF_IDX];
        ArrayList<Integer>[] edges = new ArrayList[LIMIT_OF_IDX];
        for (int i = 0; i < LIMIT_OF_IDX; i++) edges[i] = new ArrayList<>();

        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = charToIdx(st.nextToken().charAt(0));
            int b = charToIdx(st.nextToken().charAt(0));
            int c = Integer.parseInt(st.nextToken());
            capacity[a][b] += c;
            capacity[b][a] += c;
            edges[a].add(b);
            edges[b].add(a);
        }

        int sum = 0;
        while (true) {
            int[] parents = new int[LIMIT_OF_IDX];
            Arrays.fill(parents, -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(SOURCE);
            parents[SOURCE] = SOURCE;

            while (!q.isEmpty() && parents[SINK] == -1) {
                int cur = q.poll();
                for (int next : edges[cur]) {
                    if (parents[next] == -1 && capacity[cur][next] - flow[cur][next] > 0) {
                        q.add(next);
                        parents[next] = cur;
                    }
                }
            }

            if (parents[SINK] == -1) break;

            int min = Integer.MAX_VALUE;
            for (int i = SINK; i != SOURCE; i = parents[i]) {
                min = Math.min(min, capacity[parents[i]][i] - flow[parents[i]][i]);
            }

            for (int i = SINK; i != SOURCE; i = parents[i]) {
                flow[parents[i]][i] += min;
                flow[i][parents[i]] -= min;
            }
            sum += min;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
