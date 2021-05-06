import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] dist;
    private static ArrayList<Node>[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int x = parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)    arr[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int dist = parseInt(st.nextToken());
            arr[a].add(new Node(b, dist));
        }
        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i][x] + dist[x][i]);
        }
        System.out.println(max);
    }
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[n+1];
        int[] tmp = dist[start];
        Arrays.fill(tmp, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));
        tmp[start] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (v[cur.n])  continue;
            v[cur.n] = true;
            for (Node next : arr[cur.n]) {
                int nx = tmp[cur.n] + next.dist;
                tmp[next.n] = Math.min(tmp[next.n], nx);
                if (tmp[next.n] == nx)  pq.add(new Node(next.n, nx));
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
