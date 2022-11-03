import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    ArrayList<Integer>[] edges;
    int d;
    boolean[] v;
    int ans = 0;

    private int dfs(int cur) {
        int max = 0;
        for (int next : edges[cur]) {
            if (v[next]) continue;
            v[next] = true;
            max = Math.max(max, dfs(next));
        }
        if (max+1>d) ans++;
        return max+1;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        v = new boolean[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x].add(y);
            edges[y].add(x);
        }
        v[s] = true;
        dfs(s);
        System.out.println(Math.max(0, (ans-1)*2));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
