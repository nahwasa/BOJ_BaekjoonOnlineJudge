import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int n;
    List<Integer>[] edges;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num = 0;
        Map<String, Integer> comp = new HashMap<>();
        edges = new List[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (!comp.containsKey(a)) comp.put(a, num++);
            if (!comp.containsKey(b)) comp.put(b, num++);
            edges[comp.get(a)].add(comp.get(b));
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int numA = comp.getOrDefault(a, -1);
            int numB = comp.getOrDefault(b, -1);
            if (numA == -1 || numB == -1) {
                sb.append("gg ");
                continue;
            }

            if (reachable(numA, numB)) sb.append(a).append(' ');
            else if (reachable(numB, numA)) sb.append(b).append(' ');
            else sb.append("gg ");
        }
        System.out.println(sb);
    }

    private boolean reachable(final int a, final int b) {
        boolean[] v = new boolean[n];
        v[a] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : edges[cur]) {
                if (next == b) return true;

                if (v[next]) continue;
                v[next] = true;
                q.add(next);
            }
        }

        return false;
    }
}
