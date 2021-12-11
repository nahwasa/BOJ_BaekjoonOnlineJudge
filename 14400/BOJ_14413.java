import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Query implements Comparable<Query> {
    int a, b, idx;
    static int sqrtN;

    public Query(int a, int b, int idx) {
        this.a = a;
        this.b = b;
        this.idx = idx;
    }

    @Override
    public int compareTo(Query o) {
        int sqrtA1 = this.a / sqrtN;
        int sqrtA2 = o.a / sqrtN;
        if (sqrtA1 == sqrtA2) return this.b - o.b;
        return sqrtA1 - sqrtA2;
    }
}

public class Main extends FastInput {
    private HashSet<Integer> answer = new HashSet<>();
    private int[] cnt;

    private void chkAnswer(int num) {
        if (cnt[num] == 2) answer.add(num);
        else if (answer.contains(num)) answer.remove(num);
    }

    private void pushNum(int num) {
        ++cnt[num];
        chkAnswer(num);
    }

    private void popNum(int num) {
        --cnt[num];
        chkAnswer(num);
    }

    private int[] findQueryResult(int[] arr, int q, ArrayList<Query> queries) {
        int[] queryResult = new int[q];

        Query first = queries.get(0);
        for (int i = first.a; i <= first.b; i++) {
            pushNum(arr[i]);
        }
        queryResult[first.idx] = answer.size();

        for (int queryIdx = 1; queryIdx < q; queryIdx++) {
            Query cur = queries.get(queryIdx);
            Query bf = queries.get(queryIdx-1);

            for (int i = bf.a; i < cur.a; i++) popNum(arr[i]);
            for (int i = cur.a; i < bf.a; i++) pushNum(arr[i]);
            for (int i = bf.b+1; i <= cur.b; i++) pushNum(arr[i]);
            for (int i = cur.b+1; i <= bf.b; i++) popNum(arr[i]);

            queryResult[cur.idx] = answer.size();
        }
        return queryResult;
    }

    private void solution() throws Exception {
        int n = nextInt();
        Query.sqrtN = (int) Math.sqrt(n);
        int q = nextInt();

        HashMap<Integer, Integer> numCompression = new HashMap<>();
        int num = 1;
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int cur = nextInt();
            if (!numCompression.containsKey(cur))
                numCompression.put(cur, num++);
            arr[i] = numCompression.get(cur);
        }
        cnt = new int[num];

        ArrayList<Query> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(new Query(nextInt(), nextInt(), i));
        }
        Collections.sort(queries);

        int[] queryResult = findQueryResult(arr, q, queries);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(queryResult[i]).append('\n');
        }
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
