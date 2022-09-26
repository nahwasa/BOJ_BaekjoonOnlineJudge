import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[] matched;
    boolean[] v;
    int[][] edges;

    private boolean matching(int cur) {
        for (int i = 0; i < edges[cur].length; i++) {
            int next = edges[cur][i];
            if (v[next]) continue;
            v[next] = true;
            if (matched[next] == -1 || matching(matched[next])) {
                matched[next] = cur;
                return true;
            }
        }
        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        matched = new int[m+1];
        Arrays.fill(matched, -1);
        v = new boolean[m+1];
        edges = new int[n+1][];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            edges[i] = new int[a];
            for (int j = 0; j < a; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = 0;
        for (int i = 1; i <= n && sum < m; i++) {
            if (matching(i)) {
                sum++;
                v = new boolean[m+1];
            }
        }
        while (true) {
            int tmp = 0;
            for (int i = 1; i <= n && sum < m && k > 0; i++) {
                if (matching(i)) {
                    tmp++;
                    k--;
                    v = new boolean[m+1];
                }
            }
            sum += tmp;
            if (tmp == 0 || sum >= m || k == 0)
                break;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
