import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    private static void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        boolean[][] edge = new boolean[n+1][n+1];
        while (m-->0) {
            int a = nextInt();
            int b = nextInt();
            edge[a][b] = true;
            edge[b][a] = true;
        }

        StringBuilder sb = new StringBuilder();
        int order = nextInt();
        while (order-->0) {
            int o = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (o == 1) {
                edge[a][b] = true;
                edge[b][a] = true;
            } else {
                edge[a][b] = false;
                edge[b][a] = false;
            }

            Queue<Integer> q = new LinkedList<>();
            int[] dist = new int[n+1];
            Arrays.fill(dist, -1);
            dist[1] = 0;
            q.add(1);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next = 1; next <= n; next++) {
                    if (!edge[cur][next] || dist[next] != -1) continue;
                    dist[next] = dist[cur]+1;
                    q.add(next);
                }
            }
            for (int i = 1; i <= n; i++) {
                sb.append(dist[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 20;
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
