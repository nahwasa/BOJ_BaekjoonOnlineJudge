import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main extends FastInput {
    int n, sqrtN;
    int[] arr;
    int[][] bucket; //[][0]: min idx, [][1]: min value

    private void init() {
        sqrtN = (int) Math.sqrt(n);
        bucket = new int[n/sqrtN+(n%sqrtN==0?0:1)][2];
        for (int[] tmp : bucket) Arrays.fill(tmp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int idx = i/sqrtN;
            if (arr[i]<bucket[idx][1]) {
                bucket[idx][1] = arr[i];
                bucket[idx][0] = i;
            }
        }
    }

    private void update(int i, int v) {
        int idx = i/sqrtN;
        arr[i] = v;
        if (v==bucket[idx][1] && i<bucket[idx][0]) {    // same value, but small idx
            bucket[idx][0] = i;
        } else if (v<bucket[idx][1]) {  // small value
            bucket[idx][0] = i;
            bucket[idx][1] = v;
        } else if (bucket[idx][0]==i && v>bucket[idx][1]) { // same idx and bigger value
            // reset bucket
            bucket[idx][1] = Integer.MAX_VALUE;
            for (int j = idx*sqrtN; j < (idx+1)*sqrtN && j < n; j++) {
                if (arr[j]<bucket[idx][1]) {
                    bucket[idx][1] = arr[j];
                    bucket[idx][0] = j;
                }
            }
        }
    }

    private int query(int a, int b) {
        int minIdx = Integer.MAX_VALUE;
        int minVal = Integer.MAX_VALUE;
        while (a%sqrtN!=0 && a<=b) {
            if (arr[a]<minVal) {
                minIdx = a;
                minVal = arr[a];
            }
            a++;
        }

        while ((b+1)%sqrtN!=0 && a<=b) {
            if (arr[b]<minVal) {
                minIdx = b;
                minVal = arr[b];
            } else if (arr[b]==minVal && b<minIdx) {
                minIdx = b;
            }
            b--;
        }

        for (int i = a/sqrtN; i < (b+1)/sqrtN; i++) {
            if (bucket[i][1]<minVal) {
                minIdx = bucket[i][0];
                minVal = bucket[i][1];
            } else if (bucket[i][1]==minVal && bucket[i][0]<minIdx) {
                minIdx = bucket[i][0];
            }
        }

        return minIdx;
    }

    private void solution() throws Exception {
        n = nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();

        init();

        int m = nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            int q = nextInt();
            int a = nextInt();
            int b = nextInt();
            switch (q) {
                case 1: update(a-1, b); break;
                case 2: sb.append(query(a-1, b-1)+1).append('\n'); break;
            }
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
