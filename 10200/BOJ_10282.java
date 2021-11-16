import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pos {
    int to, dist;
    public Pos(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

public class Main {
    private int[] dijkstra(int n, int c, ArrayList<Pos>[] edge) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(c);
        res[c] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (Pos pos : edge[cur]) {
                int next = pos.to;
                if (res[next] > res[cur]+pos.dist) {
                    res[next] = res[cur]+pos.dist;
                    pq.add(next);
                }
            }
        }
        return res;
    }

    private void solution() throws Exception {
        int tc = nextInt();
        StringBuilder answer = new StringBuilder();
        while (tc-->0) {
            int n = nextInt();
            int d = nextInt();
            int c = nextInt();

            ArrayList<Pos>[] edge = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                edge[i] = new ArrayList<>();
            }

            while (d-->0) {
                int a = nextInt();
                int b = nextInt();
                int s = nextInt();
                edge[b].add(new Pos(a, s));
            }

            int[] res = dijkstra(n, c, edge);

            int cnt = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (res[i] == Integer.MAX_VALUE) continue;
                cnt++;
                if (max < res[i])
                    max = res[i];
            }
            answer.append(cnt).append(' ').append(max).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
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
