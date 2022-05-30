import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[] matched;
    boolean[] v;
    ArrayList<Integer>[] edges;
    private boolean matching(int a) {
        for (int b : edges[a]) {
            if (v[b]) continue;
            v[b] = true;
            if (matched[b] == -1 || matching(matched[b])) {
                matched[b] = a;
                return true;
            }
        }
        return false;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        matched = new int[n+1];
        Arrays.fill(matched, -1);
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (k-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (edges[i].size() == 0) continue;
            v = new boolean[n+1];
            if (matching(i))
                cnt++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
