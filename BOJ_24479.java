import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends FastInput {
    int[] answer;
    ArrayList<Integer>[] edges;
    int idx = 0;
    boolean[] v;

    private void dfs(int cur) {
        answer[cur] = ++idx;
        for (int next : edges[cur]) {
            if (v[next]) continue;
            v[next] = true;
            dfs(next);
        }
    }

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int r = nextInt();
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        answer = new int[n+1];
        v = new boolean[n+1];
        while (m-->0) {
            int u = nextInt();
            int v = nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }
        for (int i = 1; i <= n; i++) Collections.sort(edges[i]);
        v[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(answer[i]).append('\n');
        System.out.print(sb);
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
