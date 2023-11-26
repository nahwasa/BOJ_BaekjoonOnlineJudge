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

        int[] cnt = new int[n+1];
        List<Integer>[] edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            cnt[b]++;
        }

        int[] dist = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i]!=0) continue;
            dist[i] = 1;
            q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next : edges[cur]) {
                dist[next] = Math.max(dist[next], dist[cur]+1);
                if (--cnt[next] == 0)
                    q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(' ');
        }
        System.out.println(sb);
    }
}
