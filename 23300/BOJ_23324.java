import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] parents;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int find(int a) {
        if (parents[a] < 0)
            return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int hi = parents[a]<parents[b]?a:b;
        int lo = parents[a]<parents[b]?b:a;
        parents[hi] += parents[lo];
        parents[lo] = hi;
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        Arrays.fill(parents, -1);
        int a = 0, b = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (i == k) {
                a = u;
                b = v;
                continue;
            }

            union(u, v);
        }

        a = find(a);
        b = find(b);

        if (a == b) {
            System.out.println(0);
            return;
        }

        int aCnt = 0, bCnt = 0;
        for (int i = 1; i <= n; i++) {
            int cur = find(i);
            if (cur == a)
                aCnt++;
            else if (cur == b)
                bCnt++;
        }

        System.out.println(1l*aCnt*bCnt);
    }
}
