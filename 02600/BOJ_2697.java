import java.io.DataInputStream;
import java.io.IOException;

public class Main extends FastInput {
    private static final String BIGGEST = "BIGGEST";

    private String solve(String s) {
        if (s.length() == 1)
            return BIGGEST;

        int[] cnt = new int[10];

        int i = s.length()-2;
        for (; i >= 0; i--) {
            cnt[s.charAt(i+1)-'0']++;
            if (s.charAt(i) < s.charAt(i+1)) {
                cnt[s.charAt(i)-'0']++;
                break;
            }
        }

        if (i == -1)
            return BIGGEST;

        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < i; j++)
            answer.append(s.charAt(j));

        for (int j = (s.charAt(i)-'0')+1; j < cnt.length; j++) {
            if (cnt[j] == 0) continue;
            answer.append((char)('0'+j));
            cnt[j]--;
            break;
        }

        for (int j = 0; j < cnt.length; j++) {
            while (cnt[j]-->0) {
                answer.append((char)('0'+j));
            }
        }
        return answer.toString();
    }

    private void solution() throws Exception {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            String s = nextLine();
            sb.append(solve(s)).append('\n');
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
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 80;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static String nextLine() throws IOException {
        byte[] buf = new byte[MAX_CHAR_LEN_FOR_NEXT_LINE];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) break;
                continue;
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
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
