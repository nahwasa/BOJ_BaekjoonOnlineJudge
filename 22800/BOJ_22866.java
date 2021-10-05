import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static class Building {
        int num, height;
        public Building(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    private static void solution() throws Exception {
        int n = nextInt();
        Building[] arr = new Building[n+1];
        int[] cnt = new int[n+1];
        int[][] near = new int[n+1][2]; // near[a][b]; a:건물번호, b:0-가까운건물번호, 1-거리
        for (int[] row : near)
            Arrays.fill(row, 100001);

        for (int i = 1; i < n+1; i++) {
            arr[i] = new Building(i, nextInt());
        }

        Stack<Building> stk = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stk.isEmpty() && stk.peek().height <= arr[i].height) stk.pop();
            cnt[i] += stk.size();

            if (!stk.isEmpty()) {
                int gap = Math.abs(stk.peek().num - i);
                if (gap < near[i][1]) {
                    near[i][0] = stk.peek().num;
                    near[i][1] = gap;
                } else if (gap == near[i][1] && stk.peek().num < near[i][0]) {
                    near[i][0] = stk.peek().num;
                }
            }

            stk.push(arr[i]);
        }

        stk = new Stack<>();
        for (int i = n; i >= 1; i--) {
            while (!stk.isEmpty() && stk.peek().height <= arr[i].height) stk.pop();
            cnt[i] += stk.size();

            if (!stk.isEmpty()) {
                int gap = Math.abs(stk.peek().num - i);
                if (gap < near[i][1]) {
                    near[i][0] = stk.peek().num;
                    near[i][1] = gap;
                } else if (gap == near[i][1] && stk.peek().num < near[i][0]) {
                    near[i][0] = stk.peek().num;
                }
            }

            stk.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0)
                sb.append(0);
            else
                sb.append(cnt[i]).append(' ').append(near[i][0]);
            sb.append('\n');
        }
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
