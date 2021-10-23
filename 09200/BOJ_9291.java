import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static boolean chkRowAndCol(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            boolean[] chk1 = new boolean[10];
            boolean[] chk2 = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (chk1[arr[i][j]]) return false;
                chk1[arr[i][j]] = true;
                if (chk2[arr[j][i]]) return false;
                chk2[arr[j][i]] = true;
            }
        }
        return true;
    }

    private static boolean chkSquare(int[][] arr) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                boolean[] chk = new boolean[10];
                for (int i = r*3; i < r*3+3; i++) {
                    for (int j = c*3; j < c*3+3; j++) {
                        if (chk[arr[i][j]]) return false;
                        chk[arr[i][j]] = true;
                    }
                }

            }
        }
        return true;
    }

    private static void solution() throws Exception {
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) arr[i][j] = nextInt();
            sb.append("Case ").append(t).append(": ");
            if (!chkRowAndCol(arr) || !chkSquare(arr)) {
                sb.append("INCORRECT\n");
                continue;
            }
            sb.append("CORRECT\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 64;
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
