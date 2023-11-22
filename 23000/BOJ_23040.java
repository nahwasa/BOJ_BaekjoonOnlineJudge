import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int hi = parents[a] < parents[b] ? a:b;
        int lo = parents[a] < parents[b] ? b:a;
        parents[hi] += parents[lo];
        parents[lo] = hi;
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        Arrays.fill(parents, -1);

        List<Integer>[] edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        boolean[] colors = new boolean[n+1];
        String tmp = br.readLine();
        for (int i = 1; i <= n; i++) {
            colors[i] = tmp.charAt(i-1)=='R';
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        Set<Integer> v = new HashSet<>();
        v.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : edges[cur]) {
                if (v.contains(next)) continue;
                v.add(next);
                if (colors[cur] && colors[next])
                    union(cur, next);

                q.add(next);
            }
        }

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            if (colors[i]) continue;

            v = new HashSet<>();
            for (int next : edges[i]) {
                if (!colors[next] || v.contains(find(next))) continue;
                v.add(find(next));
                answer += -parents[find(next)];
            }
        }
        System.out.println(answer);
    }
}
