import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    List<Integer>[] edges;
    int[] answer;
    boolean[] v;

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        answer = new int[n+1];
        v = new boolean[n+1];
        edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        v[r] = true;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            int u = Integer.parseInt(br.readLine());

            sb.append(answer[u]).append('\n');
        }

        System.out.print(sb);
    }

    private int dfs(final int r) {
        int cnt = 1;

        for (Integer next : edges[r]) {
            if (v[next]) continue;
            v[next] = true;

            cnt += dfs(next);
        }

        return answer[r] = cnt;
    }
}
