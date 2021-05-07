import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        while (e-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[a][b] = d;
            arr[b][a] = d;
        }
        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int[] dist0 = new int[n+1];
        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];
        dijkstra(1, dist0);
        dijkstra(m1, dist1);
        dijkstra(m2, dist2);
        int res1 = (dist0[m1]==Integer.MAX_VALUE || dist1[m2]==Integer.MAX_VALUE || dist2[n] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dist0[m1] + dist1[m2] + dist2[n];
        int res2 = (dist0[m2]==Integer.MAX_VALUE || dist1[n]==Integer.MAX_VALUE || dist2[m1] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dist0[m2] + dist2[m1] + dist1[n];
        int res = Math.min(res1, res2);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void dijkstra(int start, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        boolean[] v = new boolean[n+1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (v[cur.n]) continue;
            v[cur.n] = true;
            for (int i = 1; i <= n; i++) {
                if (arr[cur.n][i] == 0) continue;
                int tmp = dist[cur.n] + arr[cur.n][i];
                dist[i] = Math.min(dist[i], tmp);
                if (dist[i] == tmp) pq.add(new Node(i, tmp));
            }
        }
    }
}

class Node implements Comparable<Node> {
    int n, dist;
    public Node(int n, int dist) {
        this.n = n;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
