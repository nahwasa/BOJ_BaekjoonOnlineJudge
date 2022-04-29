import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main extends FastInput {
    class Query implements Comparable<Query> {
        int s, t, d, idx;
        public Query(int s, int t, int d, int idx) {
            this.s = s;
            this.t = t;
            this.d = d;
            this.idx = idx;
        }
        @Override
        public int compareTo(Query o) {
            return this.s-o.s;
        }
    }

    private int[][] findPath(int n, int s, ArrayList<Integer>[] edges) {
        int[][] dist = new int[5001][2];
        for (int i = 1; i <= n; i++) dist[i][0] = dist[i][1] = -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s, 0});
        dist[s][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            ArrayList<Integer> edge = edges[cur[0]];
            for (int i = 0; i < edge.size(); i++) {
                int next = edge.get(i);
                if (dist[next][(cur[1]+1)&1] <= 0) {
                    dist[next][(cur[1] + 1) & 1] = cur[1] + 1;
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }
        return dist;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            int a = nextInt();
            int b = nextInt();
            edges[a].add(b);
            edges[b].add(a);
        }
        PriorityQueue<Query> pq = new PriorityQueue<>(k);
        boolean[] answer = new boolean[k];
        for (int i = 0; i < k; i++) {
            int s = nextInt();
            int t = nextInt();
            int d = nextInt();
            pq.add(new Query(s, t, d, i));
        }
        int bfS = -1;
        int[][] dist = null;
        int gcCnt = 0;
        while (!pq.isEmpty()) {
            Query cur = pq.poll();
            if (bfS != cur.s) {
                dist = findPath(n, cur.s, edges);
                bfS = cur.s;
                if (gcCnt++ == 100) {
                    System.gc();
                    gcCnt = 0;
                }
            }
            int s = cur.s; int t = cur.t; int d = cur.d; int idx = cur.idx;
            if (s == t && d == 0) {
                answer[idx] = true;
                continue;
            }
            if (dist[t][d&1] > 0 && d>=dist[t][d&1]) {
                answer[idx] = true;
                continue;
            }
            answer[idx] = false;
        }

        edges = null;
        dist = null;
        pq = null;
        System.gc();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (answer[i]) sb.append('T').append('A').append('K').append('\n');
            else sb.append('N').append('I').append('E').append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 14;
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
