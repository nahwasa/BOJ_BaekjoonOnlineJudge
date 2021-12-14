import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main extends FastInput {
    private static final int AZ_GAP = 'z'-'a'+1;
    private byte[][] arr;

    private void init() {
        arr = new byte[AZ_GAP][AZ_GAP];
        for (int i = 0; i < AZ_GAP; i++) {
            for (int j = 0; j < AZ_GAP; j++) {
                if (i == j) continue;
                int l = i<j?i:j;
                int h = i>j?i:j;
                arr[i][j] = (byte) Math.min(h-l, AZ_GAP-h+l);
            }
        }
    }

    private void solution() throws Exception {
        init();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = nextInt();
        for (int tcNum = 1; tcNum <= tc; tcNum++) {
            System.gc();
            byte[] s = nextLine(true);
            int sLen = FastInput.lastLineLen;
            byte[] f = nextLine(false);
            int fLen = FastInput.lastLineLen;

            int sum = 0;
            for (int i = 0; i < sLen; i++) {
                int cur = s[i]-'a';
                int min = AZ_GAP;
                for (int j = 0; j < fLen; j++) {
                    int gap = arr[cur][f[j]-'a'];
                    if (min > gap)
                        min = gap;
                }
                sum += min;
            }
            bw.write(String.format("Case #%d: %d\n", tcNum, sum));
            bw.flush();
        }
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
    protected static int lastLineLen = 0;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static byte[] nextLine(boolean isS) throws IOException {
        byte[] buf = new byte[isS?100001 : 27];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) break;
                continue;
            }
            buf[cnt++] = (byte)c;
        }
        lastLineLen = cnt;
        return buf;
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
