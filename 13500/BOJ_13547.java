import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

class Query implements Comparable<Query> {
    static double sqrtN;
    int a, b, factor, idx;

    public Query(int a, int b, int idx) {
        this.a = a;
        this.b = b;
        this.idx = idx;
        this.factor = (int)(a/sqrtN);
    }

    @Override
    public int compareTo(Query o) {
        if (this.factor == o.factor)
            return this.b - o.b;
        return this.factor - o.factor;
    }
}

public class Main extends FastInput {
    private int[] numCnt = new int[1000001];
    private int cnt = 0;

    private void push(int num) {
        if (++numCnt[num] == 1) cnt++;
    }
    private void pop(int num) {
        if (--numCnt[num] == 0) cnt--;
    }

    private void solution() throws Exception {
        int n = nextInt();
        Query.sqrtN = Math.sqrt(n);
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = nextInt();

        int m = nextInt();
        Query[] queries = new Query[m];
        for (int i = 0; i < m; i++)
            queries[i] = new Query(nextInt(), nextInt(), i);
        Arrays.sort(queries);

        int[] answer = new int[m];

        int prevA = queries[0].a;
        int prevB = queries[0].a-1;

        for (int i = 0; i < m; i++) {
            int curA = queries[i].a;
            int curB = queries[i].b;

            for (int k = prevA; k < curA; k++)      pop(arr[k]);
            for (int k = curA; k < prevA; k++)      push(arr[k]);
            for (int k = prevB+1; k <= curB; k++)   push(arr[k]);
            for (int k = curB+1; k <= prevB; k++)   pop(arr[k]);

            answer[queries[i].idx] = cnt;
            prevA = curA;
            prevB = curB;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++)
            sb.append(answer[i]).append('\n');
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
