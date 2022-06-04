import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[] answer;
    ArrayList<Integer>[] edges;
    int idx = 0;
    int[] v;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        answer = new int[n + 1];
        v = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        for (int i = 1; i <= n; i++) Collections.sort(edges[i], Collections.reverseOrder());

        Queue<Integer> q = new ArrayDeque<>();
        q.add(r);
        int visitCnt = 1;
        v[r] = visitCnt;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : edges[cur]) {
                if (v[next] != 0) continue;
                v[next] = ++visitCnt;
                q.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(v[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
