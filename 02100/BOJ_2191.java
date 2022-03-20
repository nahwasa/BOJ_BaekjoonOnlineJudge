import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends FastInput {
    boolean[] v;
    int[] matched;
    int m;
    ArrayList<Integer>[] edges;

    private boolean matching(int from) {
        for (int i = 0; i < edges[from].size(); i++) {
            int to = edges[from].get(i);
            if (v[to]) continue;
            v[to] = true;
            if (matched[to] == -1 || matching(matched[to])) {
                matched[to] = from;
                return true;
            }
        }
        return false;
    }

    private void solution() throws Exception {
        int n = nextInt();
        m = nextInt();
        int limit = nextInt()*nextInt();
        limit *= limit;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        double[][] tmp = new double[n][2];
        for (int i = 0; i < n; i++) {
            tmp[i][0] = nextDouble();
            tmp[i][1] = nextDouble();
        }
        for (int i = 0; i < m; i++) {
            double x = nextDouble();
            double y = nextDouble();
            for (int j = 0; j < n; j++) {
                double dist = (x-tmp[j][0])*(x-tmp[j][0])+(y-tmp[j][1])*(y-tmp[j][1]);
                if (dist <= limit)
                    edges[j].add(i);
            }
        }

        int cnt = 0;
        matched = new int[m];
        Arrays.fill(matched, -1);
        for (int i = 0; i < n; i++) {
            v = new boolean[m];
            if (matching(i))
                cnt++;
        }
        System.out.println(n-cnt);
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

    protected static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
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
