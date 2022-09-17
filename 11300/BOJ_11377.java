import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int n, m;
    int[] matched;
    ArrayList<Integer>[] edges;
    boolean[] v;

    private boolean matching(int cur) {
        for (int next : edges[cur]) {
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            edges[i] = new ArrayList<>(a);
            while (a-->0) {
                edges[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        v = new boolean[m+1];
        matched = new int[m+1];
        Arrays.fill(matched, -1);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (matching(i)) {
                cnt++;
                v = new boolean[m+1];
            }
        }

        v = new boolean[m+1];
        for (int i = 1; i <= n && k > 0; i++) {
            if (matching(i)) {
                cnt++;
                k--;
                v = new boolean[m+1];
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
