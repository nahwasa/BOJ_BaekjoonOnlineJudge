import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Query implements Comparable<Query>{
    int s, e, order;   // s means l, e means r.
    static int sqrtN;

    public Query(int s, int e, int order) {
        this.s = s;
        this.e = e;
        this.order = order;
    }

    @Override
    public int compareTo(Query another) {
        int thisS = this.s / sqrtN;
        int anotherS = another.s / sqrtN;
        if (thisS == anotherS) return this.e-another.e;
        return thisS - anotherS;
    }
}

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        Query.sqrtN = (int) Math.sqrt(n);

        int[] arr = new int[n+1];
        HashMap<Integer, Integer> compression = new HashMap<>();
        int compNum = 0;
        for (int i = 1; i <= n; i++) {
            int a = nextInt();
            if (!compression.containsKey(a)) {
                compression.put(a, compNum++);
            }
            arr[i] = compression.get(a);
        }
        compression = null;

        int q = nextInt();
        ArrayList<Query> queries = new ArrayList<>(q);
        for (int i = 0; i < q; i++) {
            queries.add(new Query(nextInt(), nextInt(), i));
        }

        Collections.sort(queries);

        int answer = 0;
        int[] answerArr = new int[q];
        int[] cnt = new int[compNum];   // maximum 100,000

        // init first
        for (int i = queries.get(0).s; i <= queries.get(0).e; i++) {
            if (++cnt[arr[i]] == 1) answer++;
        }
        answerArr[queries.get(0).order] = answer;

        // solve
        for (int idx = 1; idx < queries.size(); idx++) {
            int cs = queries.get(idx).s;
            int ce = queries.get(idx).e;
            int bs = queries.get(idx-1).s;
            int be = queries.get(idx-1).e;

            for (int i = bs; i < cs; i++) if (--cnt[arr[i]] == 0) answer--;
            for (int i = cs; i < bs; i++) if (++cnt[arr[i]] == 1) answer++;
            for (int i = be+1; i <= ce; i++) if (++cnt[arr[i]] == 1) answer++;
            for (int i = ce+1; i <= be; i++) if (--cnt[arr[i]] == 0) answer--;

            answerArr[queries.get(idx).order] = answer;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < q; i++) {
            output.append(answerArr[i]).append('\n');
        }
        System.out.print(output);
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
