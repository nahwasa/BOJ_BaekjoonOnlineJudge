import java.io.DataInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    private void solution() throws Exception {
        int tc = nextInt();
        while (tc-->0) {
            int n = nextInt();
            ans.append(n/2+1).append('\n');
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                int cur = nextInt();
                if ((i&1)==1)   pq1.add(cur);
                else            pq2.add(cur);
                if (pq1.size()*pq2.size()!=0 && pq1.peek() > pq2.peek()) {
                    pq2.add(pq1.poll());
                    pq1.add(pq2.poll());
                }
                if ((i&1)==1)   ans.append(pq1.peek()).append(' ');
                if (i%20==0)    ans.append('\n');
            }
            ans.append('\n');
        }
        flush();
    }

    //////
    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }

    private StringBuilder ans = new StringBuilder();
    private void flush() {System.out.println(ans);}

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 64;
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
