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
        ArrayList<int[]>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[k];
            for (int i = 0; i < k; i++) tmp[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) edges[tmp[i]].add(tmp);
        }
        boolean[] v = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,1});
        v[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n) {
                System.out.println(cur[1]);
                return;
            }
            for (int[] edge : edges[cur[0]]) {
                for (int next : edge) {
                    if (v[next]) continue;
                    v[next] = true;
                    q.add(new int[]{next, cur[1]+1});
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
