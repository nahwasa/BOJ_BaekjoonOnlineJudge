import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static int rangeSum(int[] arr, int day, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += Math.max(arr[i]-day, 0);
        }
        return sum;
    }

    private static void rangeRemove(int[] arr, int s, int e) {
        for (int i = s; i <= e; i++) {
            arr[i] = 0;
        }
    }

    private static void solution() throws Exception {
        int n = nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = nextInt();

        int answer = 0;
        for (int day = 0; day < n; day++) {
            int max = 0;
            int maxIdx = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j]-day > max) {
                    max = arr[j]-day;
                    maxIdx = j;
                }
            }
            if (max == 0)
                break;

            answer += max;
            arr[maxIdx] = 0;
//            int leftSum = rangeSum(arr, day, 0, maxIdx-1);
//            int rightSum = rangeSum(arr, day, maxIdx+1, n-1);
//            if (leftSum < rightSum)
//                rangeRemove(arr, 0, maxIdx-1);
//            else
//                rangeRemove(arr, maxIdx+1, n-1);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 20;
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
