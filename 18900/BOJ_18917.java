import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private void solution() throws Exception {
        int m = nextInt();
        long sum = 0;
        long xor = 0;
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            int a = nextInt();
            int b = a<=2?nextInt():0;
            switch(a) {
                case 1 :
                    sum+=b;
                    xor^=b;
                    break;
                case 2 :
                    sum-=b;
                    xor^=b;
                    break;
                case 3 : sb.append(sum).append('\n'); break;
                case 4 : sb.append(xor).append('\n'); break;
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
