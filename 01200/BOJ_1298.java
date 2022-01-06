import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private void tokenizing() throws Exception { st = new StringTokenizer(br.readLine()); }
    private int nextInt() { return Integer.parseInt(st.nextToken()); }

    ArrayList<Integer>[] edges;
    int[] matched, v;

    private boolean matching(int from) {
        for (int to : edges[from]) {
            if (v[to] != 0) continue;
            v[to] = 1;
            if (matched[to] == 0 || matching(matched[to])) {
                matched[to] = from;
                return true;
            }
        }
        return false;
    }

    private void solution() throws Exception {
        tokenizing();
        int n = nextInt();
        int m = nextInt();

        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            tokenizing();
            edges[nextInt()].add(nextInt());
        }

        matched = new int[n+1];
        v = new int[n+1];

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (matching(i)) {
                cnt++;
            }
            Arrays.fill(v, 0);
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
