import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int[] parents;
    long[] sum, power;

    int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    long solve(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return power[a];

        int hi = parents[a] < parents[b] ? a:b;
        int lo = parents[a] < parents[b] ? b:a;
        parents[hi] += parents[lo];
        parents[lo] = hi;

        power[hi] += power[lo] + sum[hi] * sum[lo];
        sum[hi] += sum[lo];

        return power[hi];
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        parents = new int[n];
        Arrays.fill(parents, -1);
        sum = new long[n];
        power = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sum[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(solve(a, b)).append('\n');
        }

        System.out.print(sb);
    }
}
