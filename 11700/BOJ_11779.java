import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b,c});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] dist = new int[n+1];
        Arrays.fill(dist, 100000001);
        dist[s] = 0;
        int[] parents = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int cur = tmp[0];
            int d = tmp[1];
            if (d > dist[cur]) continue;
            for (int[] edge : edges[cur]) {
                int next = edge[0];
                int nd = d + edge[1];
                if (dist[next] <= nd) continue;
                dist[next] = nd;
                parents[next] = cur;
                pq.add(new int[]{next, nd});
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = e; i != 0; i = parents[i]) {
            path.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[e]).append('\n');
        sb.append(path.size()).append('\n');
        for (int i = path.size()-1; i >= 0; i--)
            sb.append(path.get(i)).append(' ');

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
