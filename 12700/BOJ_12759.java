import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private boolean chk(int[][] arr) {
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) return true;
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) return true;
        }
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) return true;
        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) return true;
        return false;
    }

    private void solution() throws Exception {
        int s = nextInt();
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = -(i+1)*(j+1);
            }
        }
        for (int i = 0; i < 9; i++) {
            arr[nextInt()-1][nextInt()-1] = s;
            if (chk(arr)) {
                System.out.println(s);
                return;
            }
            s = 3-s;
        }
        System.out.println(0);
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
