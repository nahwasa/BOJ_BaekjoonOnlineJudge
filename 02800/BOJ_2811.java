import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private void solution() throws Exception {
        int n = nextInt();
        int[] arr = new int[n+1];
        int cnt = 0;
        ArrayList<Integer> maxIdxs = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n+1; i++) {
            int cur = i==n ? 1 : nextInt();
            if (cur >= 0) {
                if (i-cnt >= 0)
                    arr[i-cnt] = cnt;
                if (max < cnt) {
                    max = cnt;
                    maxIdxs = new ArrayList<>();
                }
                if (max <= cnt)
                    maxIdxs.add(i-cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }

        boolean[] day = new boolean[n];
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            for (int j = Math.max(0, i-2*arr[i]); j <= Math.max(0, i-1); j++) {
                if (i != 0 && !day[j]) {
                    cnt++;
                    day[j] = true;
                }
            }
        }

        int maxCnt = -1;
        for (int i : maxIdxs) {
            int tmpCnt = 0;
            for (int j = Math.max(0, i-3*arr[i]); j <= Math.max(0, i-1); j++) {
                if (i != 0 && !day[j])
                    tmpCnt++;
            }
            if (tmpCnt > maxCnt) {
                maxCnt = tmpCnt;
            }
        }

        System.out.println(cnt+maxCnt);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
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
