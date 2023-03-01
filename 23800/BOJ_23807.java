import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;

class Edge {
    int to;
    int w;
    public Edge(int to, int w) {
        this.to = to;
        this.w = w;
    }
}

class Pos implements Comparable<Pos> {
    int n;
    long dist;
    public Pos(int n, long dist) {
        this.n = n;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pos o) {
        if (this.dist > o.dist) return 1;
        else if (this.dist < o.dist) return -1;
        return 0;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final StringBuilder sb = new StringBuilder();
    private static final long INF = 300_000L * 1_000_000L + 1;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(br.readLine());
        int[] pList = new int[p];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            pList[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Map<Integer, Long>> distances = new HashMap<>();
        distances.put(x, getDistances(n, x, edges, pList, z));

        for (int i = 0; i < p; i++) {
            int y = pList[i];
            distances.put(y, getDistances(n, y, edges, pList, z));
        }
        edges = null;

        System.out.println(answer(x, pList, z, distances));
    }

    private Map<Integer, Long> getDistances(int n, int start, List<Edge>[] edges, int[] target, int z) {
        long[] dist = new long[n+1];
        Map<Integer, Long> result = new HashMap<>();
        Arrays.fill(dist, INF);

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            if (cur.dist > dist[cur.n]) continue;
            for (Edge next : edges[cur.n]) {
                long nextDist = cur.dist + next.w;
                if (nextDist < dist[next.to]) {
                    dist[next.to] = nextDist;
                    pq.add(new Pos(next.to, nextDist));
                }
            }
        }
        result.put(z, dist[z]);
        for (int num : target) {
            result.put(num, dist[num]);
        }
        return result;
    }

    private long answer(int x, int[] pList, int z, Map<Integer, Map<Integer, Long>> distances) {
        int p = pList.length;
        long answer = INF;
        for (int a = 0; a < p; a++) {
            for (int b = 0; b < p; b++) {
                for (int c = 0; c < p; c++) {

                    if (a==b || b==c || a==c) continue;
                    int an = pList[a];
                    int bn = pList[b];
                    int cn = pList[c];
                    answer = min(answer, getTotalDistance(distances, x, an, bn, cn, z));

                }
            }
        }

        return answer >= INF ? -1 : answer;
    }

    private long getTotalDistance(Map<Integer, Map<Integer, Long>> distances, int x, int a, int b, int c, int z) {
        return distances.get(x).get(a) + distances.get(a).get(b) + distances.get(b).get(c) + distances.get(c).get(z);
    }
}
