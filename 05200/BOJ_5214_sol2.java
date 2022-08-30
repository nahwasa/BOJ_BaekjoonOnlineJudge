import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<17);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] edges = new ArrayList[n+1+m];
        boolean[] v = new boolean[n+1+m];
        for (int i = 1; i <= n+m; i++) edges[i] = new ArrayList<>();
        while (m>0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                int cur = Integer.parseInt(st.nextToken());
                edges[n+m].add(cur);
                edges[cur].add(n+m);
            }
            m--;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,1});
        v[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n) {
                System.out.println(cur[1]);
                return;
            }
            for (int next : edges[cur[0]]) {
                if (v[next]) continue;
                v[next] = true;
                q.add(new int[]{next, next>n?cur[1]:cur[1]+1});
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
