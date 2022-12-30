import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        HashSet<Integer> isC = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == 'c')
                isC.add(num);
        }

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (isC.contains(a))
                edges[a].add(b);
            else
                edges[b].add(a);
        }

        int answer = getAnswer(n, n, edges);
        System.out.println(n-answer);
    }

    private int getAnswer(int from, int to, List<Integer>[] edges) {
        int[] matched = new int[to+1];
        Arrays.fill(matched, -1);
        int answer = 0;
        for (int i = 1; i <= from; i++) {
            boolean[] v = new boolean[to+1];
            if (matching(i, edges, v, matched))
                answer++;
        }
        return answer;
    }

    private boolean matching(int cur, List<Integer>[] edges, boolean[] v, int[] matched) {
        for (int next : edges[cur]) {
            if (v[next]) continue;
            v[next] = true;
            if (matched[next] == -1 || matching(matched[next], edges, v, matched)) {
                matched[next] = cur;
                return true;
            }
        }
        return false;
    }
}
