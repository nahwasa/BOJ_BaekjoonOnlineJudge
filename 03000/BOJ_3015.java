import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static class People {
        int height, cnt;
        public People(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

    private static void solution() throws Exception {
        int n = nextInt();
        Stack<People> stk = new Stack<>();
        long sum = 0;
        while (n-->0) {
            int cur = nextInt();
            while (!stk.isEmpty() && stk.peek().height < cur) {
               sum += stk.pop().cnt;
            }

            int tmp = 0;
            if (!stk.isEmpty() && stk.peek().height == cur) {
               tmp = stk.pop().cnt;
            }
            sum += tmp;

            if (!stk.isEmpty())
                sum++;

            stk.push(new People(cur, tmp+1));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 101;
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
