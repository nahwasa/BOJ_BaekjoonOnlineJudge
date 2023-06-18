import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] bipartite;
    List<Integer>[] edges;
    int n;


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        bipartite = new int[n+1];
        Arrays.fill(bipartite, -1);

        for (int i = 1; i <= n; i++) {
            if (bipartite[i] != -1) continue;

            if (!makeBipartite(i, 0)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    private boolean makeBipartite(final int idx, final int bipartiteNum) {
        if (bipartite[idx] != -1) {
            return bipartite[idx] == bipartiteNum;
        }

        bipartite[idx] = bipartiteNum;
        for (Integer next : edges[idx]) {
            if (!makeBipartite(next, 1-bipartiteNum))
                return false;
        }

        return true;
    }
}
