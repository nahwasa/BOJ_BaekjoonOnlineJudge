import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Main extends FastInput {
    private static final String SAME = "Same Same;\n";
    private static final String DIFF = "No;\n";

    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        if (b == -1) return;

        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = parents[a]<=parents[b]?a:b;
        int l = parents[a]<=parents[b]?b:a;
        parents[h]+=parents[l];
        parents[l] = h;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        parents = new int[n+1];
        Arrays.fill(parents, -1);
        int[] mento = new int[n+1];
        for (int i = 1; i <= n; i++) mento[i] = nextInt();
        mento[0] = -1;

        int[] round = new int[m+1];
        HashSet<Integer> chk = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            round[i] = nextInt();
            if (chk.contains(round[i])) round[i] = 0;
            else chk.add(round[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!chk.contains(i))
                union(i, mento[i]);
        }
        chk = null;

        Query[] queries = new Query[k];
        for (int i = 0; i < k; i++) queries[i] = new Query(i, nextInt(), nextInt(), nextInt());
        Arrays.sort(queries);

        boolean[] answer = new boolean[k];
        for (int i = 0; i < k; i++) {
            Query cur = queries[i];
            while (m>cur.a) union(round[m], mento[round[m--]]);
            answer[cur.idx] = find(cur.b) == find(cur.c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(answer[i]?SAME:DIFF);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class Query implements Comparable<Query> {
    int idx, a, b, c;
    public Query(int idx, int a, int b, int c) {
        this.idx=idx; this.a=a; this.b=b; this.c=c;
    }

    @Override
    public int compareTo(Query o) {
        return o.a - this.a;
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
