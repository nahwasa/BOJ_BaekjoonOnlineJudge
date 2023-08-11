import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] bToA = new List[n+1];
        List<Integer>[] aToB = new List[n+1];
        for (int i = 1; i <= n; i++) {
            bToA[i] = new ArrayList<>();
            aToB[i] = new ArrayList<>();
        }

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bToA[b].add(a);
            aToB[a].add(b);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bfs(n, x, bToA)).append(' ').append(n + 1 - bfs(n, x, aToB));
        System.out.println(sb);
    }

    private int bfs(final int n, final int x, final List<Integer>[] edges) {
        boolean[] v = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        v[x] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            for (int next : edges[cur]) {
                if (v[next]) continue;
                v[next] = true;
                q.add(next);
            }
        }
        return cnt;
    }
}
