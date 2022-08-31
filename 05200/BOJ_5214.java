import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
            int[] tmp = new int[k+1];
            tmp[0] = m;
            for (int i = 1; i <= k; i++) tmp[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= k; i++) edges[tmp[i]].add(tmp);
        }
        boolean[] v = new boolean[n+1];
        HashSet<Integer> edgeV = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,1});
        v[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n) {
                System.out.println(cur[1]);
                return;
            }
            ArrayList<int[]> edgesList = edges[cur[0]];
            for (int i = 0; i < edgesList.size(); i++) {
                int[] edge = edgesList.get(i);
                if (edgeV.contains(edge[0])) continue;
                edgeV.add(edge[0]);
                for (int j = 1; j <= k; j++) {
                    int next = edge[j];
                    if (v[next]) continue;
                    v[next] = true;
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
