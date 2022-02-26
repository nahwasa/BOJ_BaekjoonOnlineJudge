import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = (int)nextDouble();
        double[] max = new double[8];
        max[0] = -1;
        int i = 1;
        for(; i <= 7; i++) max[i] = nextDouble();
        Arrays.sort(max);

        for (; i <= n; i++) {
            double cur = nextDouble();
            if (cur >= max[7]) continue;
            for (int j = 7; j >= 0; j--) {
                if (max[j] <= cur) {
                    for (int k = 7; k > j+1; k--)
                        max[k] = max[k-1];
                    max[j+1] = cur;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(i = 1; i <= 7; i++) sb.append(String.format("%.3f\n", max[i]));
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

    protected static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
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
