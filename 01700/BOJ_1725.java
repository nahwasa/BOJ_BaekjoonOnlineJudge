import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static int[] arr;
    static long max;
    static int n;

    private static void popStackUntilH(Stack<Integer> stk, int curIdx) {
        int curHeight = curIdx == n ? 0 : arr[curIdx];
        while (!stk.isEmpty() && arr[stk.peek()] > curHeight) {
            int h = arr[stk.pop()];
            int w = stk.isEmpty() ? curIdx : curIdx - stk.peek() - 1;
            max = Math.max(max, 1l*h*w);
        }
    }

    private static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        n = nextInt();
        arr = new int[n];
        max = 0l;

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            int curH = arr[i];
            if (stk.isEmpty() || arr[stk.peek()] <= curH) {
                stk.push(i); continue;
            }

            popStackUntilH(stk, i);
            stk.push(i);
        }
        popStackUntilH(stk, n);
        sb.append(max).append('\n');

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
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
