import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int n, k;
    ArrayList<Integer>[] edges;
    int[] ex;

    private int dfs(int node, int cnt) {
        if (cnt == k+1) return 0;
        int sum = ex[node];
        for (int next : edges[node]) {
            sum += dfs(next, cnt+1);
        }
        return sum;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<17);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ex = new int[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[p].add(c);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) ex[i] = st.nextToken().charAt(0)-'0';
        System.out.println(dfs(0, 0));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
