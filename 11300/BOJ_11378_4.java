import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    int[] matched;
    boolean[] v;
    int[][] edges;
    int[] fullEdge;
    int n;

    private boolean matching(int cur) {
        int[] edge = cur <= n ? edges[cur] : fullEdge;
        for (int next : edge) {
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
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        matched = new int[m+1];
        Arrays.fill(matched, -1);
        v = new boolean[m+1];
        edges = new int[n+1][];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            edges[i] = new int[a];
            for (int j = 0; j < a; j++) {
                hs.add(edges[i][j] = Integer.parseInt(st.nextToken()));
            }
        }
        fullEdge = new int[hs.size()];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            if (hs.contains(i+1))
                fullEdge[idx++] = i+1;
        }

        int sum = 0;
        for (int i = 1; i < n+k+1 && sum < m; i++) {
            if (matching(i)) {
                sum++;
                v = new boolean[m+1];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
