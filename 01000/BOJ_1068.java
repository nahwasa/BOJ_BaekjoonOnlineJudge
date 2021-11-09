import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    int leafCnt, erase;
    boolean[] v;
    ArrayList<Integer>[] edge;

    private void dfs(int cur) {
        int cnt = 0;
        for (int next : edge[cur]) {
            if (next == erase) continue;
            cnt++;
            if (v[next]) continue;
            v[next] = true;
            dfs(next);
        }
        if (cnt == 0)
            leafCnt++;
    }

    private void solution() throws Exception {
        int n = nextInt();
        edge = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            if (a == -1) {
                root = i;
                continue;
            }
            edge[a].add(i);
        }
        erase = nextInt();
        if (erase == root) {
            System.out.println(0);
            return;
        }

        v = new boolean[n];
        v[root] = true;
        leafCnt = 0;
        dfs(root);
        System.out.println(leafCnt);
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
