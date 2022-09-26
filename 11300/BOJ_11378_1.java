import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int source = 0;
        int sink = n+m+m+1;
        int len = sink+1;
        int[][] capacity = new int[len][len];
        int[][] flow = new int[len][len];
        ArrayList<Integer>[] edges = new ArrayList[len];
        for (int i = 0; i < len; i++) edges[i] = new ArrayList<>();

        // source to N
        for (int i = 1; i <= n; i++) {
            capacity[source][i] = 1;
            edges[source].add(i);
            edges[i].add(source);
        }

        // N to M
        for (int i = 1; i <= n; i++) {
            int a = nextInt();
            while (a-->0) {
                int tmp = nextInt();
                capacity[i][tmp+n] = 1;
                edges[i].add(tmp+n);
                edges[tmp+n].add(i);
            }
        }

        // M to M'
        for (int i = n+1; i <= n+m; i++) {
            capacity[i][i+m] = 1;
            edges[i].add(i+m);
            edges[i+m].add(i);
        }

        // M' to sink
        for (int i = n+m+1; i <= n+m+m; i++) {
            capacity[i][sink] = 1;
            edges[i].add(sink);
            edges[sink].add(i);
        }

        // solution
        int sum = 0;

        while (true) {
            int[] parents = new int[len];
            Arrays.fill(parents, -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(source);
            parents[source] = source;

            while (!q.isEmpty() && parents[sink] == -1) {
                int cur = q.poll();
                for (int next : edges[cur]) {
                    if (parents[next] == -1 && capacity[cur][next] - flow[cur][next] > 0) {
                        parents[next] = cur;
                        q.add(next);
                    }
                }
            }

            if (parents[sink] == -1) break;

            int min = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parents[i]) {
                min = Math.min(min, capacity[parents[i]][i] - flow[parents[i]][i]);
            }

            for (int i = sink; i != source; i = parents[i]) {
                flow[parents[i]][i] += min;
                flow[i][parents[i]] -= min;
            }
            sum += min;
        }

        for (int x = 1; x <= n && sum < m && k > 0; x++) {
            capacity[0][x] += k;
            int sumTmp = 0;
            while (true) {
                int[] parents = new int[len];
                Arrays.fill(parents, -1);
                Queue<Integer> q = new ArrayDeque<>();
                q.add(source);
                parents[source] = source;

                while (!q.isEmpty() && parents[sink] == -1) {
                    int cur = q.poll();
                    for (int next : edges[cur]) {
                        if (parents[next] == -1 && capacity[cur][next] - flow[cur][next] > 0) {
                            parents[next] = cur;
                            q.add(next);
                        }
                    }
                }

                if (parents[sink] == -1) break;

                int min = Integer.MAX_VALUE;
                for (int i = sink; i != source; i = parents[i]) {
                    min = Math.min(min, capacity[parents[i]][i] - flow[parents[i]][i]);
                }

                for (int i = sink; i != source; i = parents[i]) {
                    flow[parents[i]][i] += min;
                    flow[i][parents[i]] -= min;
                }
                sumTmp += min;
            }
            sum += sumTmp;
            k -= sumTmp;
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
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
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
