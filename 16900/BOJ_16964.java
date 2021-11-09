import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    int idx = 0;
    boolean[] v;
    ArrayList<Integer>[] edge;
    int[] target;

    private boolean dfs(int cur) {
        if (target[idx++] != cur)
            return false;
        for (int next : edge[cur]) {
            if (v[next]) continue;
            v[next] = true;
            return dfs(next);
        }
        return true;
    }

    private void solution() throws Exception {
        int n = nextInt();
        edge = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            edge[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            edge[a].add(b);
            edge[b].add(a);
        }

        target = new int[n];
        int[] order = new int[n+1];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            target[i] = a;
            order[a] = i;
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(edge[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return order[o1] - order[o2];
                }
            });
        }

        v = new boolean[n+1];
        v[1] = true;
        System.out.println(dfs(1) ? 1 : 0);
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
