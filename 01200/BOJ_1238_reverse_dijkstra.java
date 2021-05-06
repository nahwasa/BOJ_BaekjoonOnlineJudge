import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int x = parseInt(st.nextToken());
        ArrayList<Node>[] arr = new ArrayList[n+1];
        ArrayList<Node>[] rArr = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            rArr[i] = new ArrayList<>();
        }
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int dist = parseInt(st.nextToken());
            arr[a].add(new Node(b, dist));
            rArr[b].add(new Node(a, dist));
        }
        int[] dist = new int[n+1];
        int[] rDist = new int[n+1];
        dijkstra(x, arr, dist);
        dijkstra(x, rArr, rDist);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i] + rDist[i]);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start, ArrayList<Node>[] arr, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (v[cur.n])  continue;
            v[cur.n] = true;
            for (Node next : arr[cur.n]) {
                int nx = dist[cur.n] + next.dist;
                dist[next.n] = Math.min(dist[next.n], nx);
                if (dist[next.n] == nx)  pq.add(new Node(next.n, nx));
            }
        }
    }
    private static int parseInt(String s) {
        return Integer.parseInt(s);
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
