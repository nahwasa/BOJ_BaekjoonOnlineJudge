import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<Integer> flipOrder;

    private static int findPancakeIdx(int[] arr, int pancake) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pancake)
                return i;
        }
        return -1;
    }

    private static int[] flip(int[] arr, int to) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i <= to; i++) {
            tmp[to-i+1] = arr[i];
        }
        flipOrder.add(to);
        return tmp;
    }

    private static void solution() throws Exception {
        int t = nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-->0) {
            flipOrder = new ArrayList<>();
            int n = nextInt();
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++)
                arr[i] = nextInt();

            while (n != 0) {
                int idx = findPancakeIdx(arr, n);
                while (idx != n) {
                    if (idx == 1) {
                        arr = flip(arr, n);
                    } else {
                        arr = flip(arr, idx);
                    }

                    idx = findPancakeIdx(arr, n);
                }
                n--;
            }
            answer.append(flipOrder.size()).append(' ');
            for (int i = 0; i < flipOrder.size(); i++) {
                answer.append(flipOrder.get(i)).append(' ');
            }
            answer.append('\n');
        }
        System.out.println(answer);
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
