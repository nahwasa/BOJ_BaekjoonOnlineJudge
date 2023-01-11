import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);
    int[][] parents;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int find(int a) {
        if (parents[0][a] < 0) return a;
        return parents[0][a] = find(parents[0][a]);
    }

    private int findCandy(int a) {
        a = find(a);
        return parents[1][a];
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return;

        int hi = parents[0][a]<parents[0][b] ? a:b;
        int lo = parents[0][a]<parents[0][b] ? b:a;
        parents[0][hi] += parents[0][lo];
        parents[1][hi] += parents[1][lo];
        parents[0][lo] = hi;
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parents = new int[2][n+1];
        Arrays.fill(parents[0], -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            parents[1][i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        List<int[]> group = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != find(i)) continue;
            group.add(new int[]{-parents[0][i], parents[1][i]});
        }

        int[] dp = new int[k];
        for (int[] each : group) {
            int a = each[0];
            int b = each[1];
            for (int i = k-1; i >= a; i--) {
                dp[i] = Math.max(dp[i], dp[i-a]+b);
            }
        }
        System.out.println(dp[k-1]);
    }
}
