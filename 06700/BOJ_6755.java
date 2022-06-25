import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private ArrayList<Integer>[] edges;
    private boolean[] v;
    private boolean dfs(int s, int e) {
        if (s == e) return true;
        for (int next : edges[s]) {
            if (v[next]) continue;
            v[next] = true;
            if (dfs(next, e)) return true;
        }
        return false;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x].add(y);
        }
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        v = new boolean[n+1];
        v[p] = true;
        if (dfs(p, q)) {
            System.out.println("yes");
            return;
        }
        v = new boolean[n+1];
        v[q] = true;
        if (dfs(q, p)) {
            System.out.println("no");
            return;
        }
        System.out.println("unknown");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
