import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private static final String MAJOR_WINNER    = "majority winner ";
    private static final String MINOR_WINNER    = "minority winner ";
    private static final String NO_WINNER       = "no winner";
    private void solution() throws Exception {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = nextInt();
            int max = 0;
            int maxIdx = -1;
            int sum = 0;
            int idx = 0;
            boolean chk = true;
            while (idx++<n) {
                int cur = nextInt();
                if (max<cur) { max=cur; maxIdx=idx; chk=true; }
                else if (max==cur) { chk=false; }
                sum+=cur;
            }
            if (!chk) sb.append(NO_WINNER);
            else if (max>=sum/2+1) sb.append(MAJOR_WINNER).append(maxIdx);
            else sb.append(MINOR_WINNER).append(maxIdx);
            sb.append('\n');
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
