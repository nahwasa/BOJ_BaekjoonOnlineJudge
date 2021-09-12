import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    static class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int bingoCnt(boolean[][] chk) {
        int[] colCnt = new int[5];
        int[] rowCnt = new int[5];
        int[] diagonalCnt = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (chk[i][j]) {
                    colCnt[j]++;
                    rowCnt[i]++;
                    if (i == j) diagonalCnt[0]++;
                    if (j == 4-i) diagonalCnt[1]++;
                }
            }
        }
        int cntSum = 0;
        for (int i = 0; i < 5; i++) {
            if (colCnt[i] == 5) cntSum++;
            if (rowCnt[i] == 5) cntSum++;
            if (i<=1 && diagonalCnt[i] == 5) cntSum++;
        }
        return cntSum;
    }

    public static void main(String[] args) throws IOException {
        initFI();
        Pos[] arr = new Pos[26];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[nextInt()] = new Pos(i, j);
            }
        }
        boolean[][] chk = new boolean[5][5];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Pos tmp = arr[nextInt()];
                chk[tmp.r][tmp.c] = true;
                if (cnt++ < 11) continue;
                int bingoCnt = bingoCnt(chk);
                if (bingoCnt >= 3) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
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
