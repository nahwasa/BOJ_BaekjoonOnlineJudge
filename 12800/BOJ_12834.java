import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge {
    int to, dist;
    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

class Node implements Comparable<Node> {
    int num, distFromStart;
    public Node(int num, int distFromStart) {
        this.num = num;
        this.distFromStart = distFromStart;
    }

    @Override
    public int compareTo(Node o) {
        return this.distFromStart - o.distFromStart;
    }
}

public class Main extends FastInput {
    private static final int INFINITY = 10000*100+1;

    private int[] findAllShortestDistFromStart(int v, int start, ArrayList<Edge>[] edges) {
        int[] res = new int[v+1];
        Arrays.fill(res, INFINITY);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        res[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (res[cur.num] < cur.distFromStart) continue;

            for (Edge next : edges[cur.num]) {
                if (res[next.to] <= cur.distFromStart + next.dist) continue;
                res[next.to] = cur.distFromStart + next.dist;
                pq.add(new Node(next.to, res[next.to]));
            }
        }

        return res;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int v = nextInt();
        int e = nextInt();

        int goal1 = nextInt();
        int goal2 = nextInt();

        int[] member = new int[n+1];
        for (int i = 1; i <= n; i++) member[i] = nextInt();

        ArrayList<Edge>[] edges = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) edges[i] = new ArrayList<>();
        while(e-->0) {
            int a = nextInt();
            int b = nextInt();
            int l = nextInt();
            edges[a].add(new Edge(b, l));
            edges[b].add(new Edge(a, l));
        }

        int[] res1 = findAllShortestDistFromStart(v, goal1, edges);
        int[] res2 = findAllShortestDistFromStart(v, goal2, edges);

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int distToGoal1 = res1[member[i]] == INFINITY ? -1 : res1[member[i]];
            int distToGoal2 = res2[member[i]] == INFINITY ? -1 : res2[member[i]];
            sum += distToGoal1 + distToGoal2;
        }
        System.out.println(sum);
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
