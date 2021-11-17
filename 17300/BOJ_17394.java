import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Main {
    HashSet<Integer> pn;

    private void initPn() {
        pn = new HashSet<>();
        boolean[] arr = new boolean[100001];
        for (int i = 2; i <= Math.sqrt(100000); i++) {
            if (arr[i]) continue;
            int base = i+i;
            while (base <= 100000) {
                arr[base] = true;
                base += i;
            }
        }
        for (int i = 2; i <= 100000; i++) {
            if (!arr[i]) pn.add(i);
        }
    }

    private int bfs(int n, int a, int b) {
        int limit = Math.max(n, b);
        boolean[] v = new boolean[limit+1];
        int[] dist = new int[limit+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        v[n] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (a<=cur && cur<=b && pn.contains(cur)) {
                return dist[cur];
            }
            for (int i = 0; i < 4; i++) {
                int next = cur;
                switch (i) {
                    case 0 : next/=2; break;
                    case 1 : next/=3; break;
                    case 2 : next+=1; break;
                    case 3 : next-=1; break;
                }

                if (next<0 || next>limit || v[next]) continue;
                v[next] = true;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        return -1;
    }

    private void solution() throws Exception {
        initPn();
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = nextInt();
            int a = nextInt();
            int b = nextInt();
            sb.append(bfs(n, a, b)).append('\n');
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
