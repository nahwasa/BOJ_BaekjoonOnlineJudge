import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    ArrayList<Integer>[] edges;
    private int[] matched;
    private boolean[] v;

    private boolean matching(int from) {
        for (int to : edges[from]) {
            if (v[to]) continue;
            v[to] = true;
            if (matched[to] == -1 || matching(matched[to])) {
                matched[to] = from;
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

        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (s-->0) edges[i].add(Integer.parseInt(st.nextToken())-1);
        }

        matched = new int[m];
        Arrays.fill(matched, -1);
        v = new boolean[m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (matching(i)) {
                cnt++;
                v = new boolean[m];
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
