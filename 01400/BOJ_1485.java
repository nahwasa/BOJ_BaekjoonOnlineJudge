import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    class Pos {
        int a, b;
        public Pos(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private long dist(Pos p1, Pos p2) {
        return 1l*(p1.a-p2.a)*(p1.a-p2.a)+1l*(p1.b-p2.b)*(p1.b-p2.b);
    }

    private void solution() throws Exception {
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            Pos[] arr = new Pos[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = new Pos(nextInt(), nextInt());
            }
            long[] dist = new long[6];
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i+1; j < 4; j++) {
                    dist[idx++] = dist(arr[i], arr[j]);
                }
            }
            Arrays.sort(dist);
            if (dist[0] == dist[1] && dist[1] == dist[2] && dist[2] == dist[3] && dist[4] == dist[5])
                sb.append(1);
            else
                sb.append(0);
            sb.append('\n');
        }
        System.out.print(sb);
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
