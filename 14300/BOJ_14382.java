import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private int remain;
    boolean[] chk;

    private boolean chkNum(int num) {
        while (num != 0) {
            int cur = num%10;
            num/=10;
            if (chk[cur]) continue;

            if (--remain == 0)
                return true;
            chk[cur] = true;
        }
        return false;
    }

    private void solution() throws Exception {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            int n = nextInt();
            if (n == 0) {
                sb.append("Case #").append(tc).append(':').append(' ').append("INSOMNIA").append('\n');
                continue;
            }

            remain = 10;
            chk = new boolean[10];
            int num = n;

            while(!chkNum(num)) {
                num+=n;
            }
            sb.append("Case #").append(tc).append(':').append(' ').append(num).append('\n');
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
