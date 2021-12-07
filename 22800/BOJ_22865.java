import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge {
    int to, dist;
    public Edge(int to, int dist) {this.to=to; this.dist=dist;}
}

class Node implements Comparable<Node> {
    int n, distFromS;
    public Node(int n, int distFromS) {this.n=n; this.distFromS=distFromS;}

    @Override
    public int compareTo(Node o) {
        return this.distFromS-o.distFromS;
    }
}

public class Main extends FastInput {
    private static final int MAX_DIST = 100000*10000+1;

    private int[] getMinDist(int n, int start, ArrayList<Edge>[] edges) {
        int[] v = new int[n+1];
        Arrays.fill(v, MAX_DIST);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        v[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (v[cur.n] < cur.distFromS) continue;
            for (Edge next : edges[cur.n]) {
                int nextDist = cur.distFromS + next.dist;
                if (v[next.to] <= nextDist) continue;
                v[next.to] = nextDist;
                pq.add(new Node(next.to, nextDist));
            }
        }

        return v;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int[] abc = new int[3];
        for (int i = 0; i < 3; i++) abc[i] = nextInt();

        ArrayList<Edge>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        int m = nextInt();
        for (int i = 1; i <= m; i++) {
            int d = nextInt();
            int e = nextInt();
            int l = nextInt();
            edges[d].add(new Edge(e, l));
            edges[e].add(new Edge(d, l));
        }

        int[] tmp = new int[n+1];
        Arrays.fill(tmp, MAX_DIST);
        for (int i = 0; i < 3; i++) {
            int[] v = getMinDist(n, abc[i], edges);
            for (int j = 1; j <= n; j++) {
                tmp[j] = Math.min(tmp[j], v[j]);
            }
        }
        for (int i = 0; i < 3; i++) tmp[abc[i]] = MAX_DIST;

        int max = 0;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (tmp[i] == MAX_DIST) continue;

            if (max < tmp[i]) {
                answer = i;
                max = tmp[i];
            }
        }
        System.out.println(answer);
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
