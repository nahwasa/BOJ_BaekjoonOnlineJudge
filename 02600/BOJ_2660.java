import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private static void solution() throws Exception {
        int n = nextInt();
        int[][] arr = new int[n+1][n+1];
        for (int[] row : arr)
            Arrays.fill(row, 51);
        while (true) {
            int a = nextInt();
            int b = nextInt();
            if (a < 0 || b < 0) break;
            arr[a][b] = arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int tmp = 51;
        for (int i = 1; i <= n; i++) {
            int cur = -1;
            for (int j = 1; j <= n; j++) {
                if (i == j || arr[i][j] == 51) continue;
                cur = Math.max(cur, arr[i][j]);
            }
            if (tmp > cur) {
                answer = new ArrayList<>();
                tmp = cur;
            }
            if (tmp == cur) {
                answer.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(tmp).append(' ').append(answer.size()).append('\n');
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++)
            sb.append(answer.get(i)).append(' ');
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
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
