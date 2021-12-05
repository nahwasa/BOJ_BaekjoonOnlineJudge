import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Edge {
    int n;
    int d;
    public Edge(int n, int d) {
        this.n = n;
        this.d = d;
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

public class Main extends FastInput {
    private static final long DIST_LIMIT = 300000l * 1000000l + 1;

    private long[] getMinDist(int n, int start, ArrayList<Edge>[] edges) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, DIST_LIMIT);

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            if (cur.dist > dist[cur.n]) continue;
            for (Edge next : edges[cur.n]) {
                long nextDist = cur.dist + next.d;
                if (nextDist < dist[next.n]) {
                    dist[next.n] = nextDist;
                    pq.add(new Pos(next.n, nextDist));
                }
            }
        }
        return dist;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();

        ArrayList<Edge>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        while(m-->0) {
            int u = nextInt();
            int v = nextInt();
            int w = nextInt();
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }
        int x = nextInt();
        int z = nextInt();

        long[] fromX = getMinDist(n, x, edges);
        long[] toZ = getMinDist(n, z, edges);

        long answer = DIST_LIMIT;
        int p = nextInt();
        while(p-->0) {
            int y = nextInt();
            if (fromX[y] == DIST_LIMIT || toZ[y] == DIST_LIMIT) continue;

            long distSum = fromX[y] + toZ[y];
            if (answer > distSum)
                answer = distSum;
        }
        System.out.println(answer == DIST_LIMIT ? -1 : answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
