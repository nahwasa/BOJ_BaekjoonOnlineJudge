import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        boolean[] arr = new boolean[n+1];
        ArrayList<Integer> remain = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int cur = nextInt();

            if (cur > n || arr[cur]) remain.add(cur);
            else arr[cur] = true;
        }
        Collections.sort(remain);

        int remainIdx = 0;
        long sum = 0;
        for (int i = 1; i <= n && remainIdx != remain.size(); i++) {
            if (arr[i]) continue;
            sum += Math.abs(i-remain.get(remainIdx++));
        }
        for (int i = n; remainIdx != remain.size(); i++) {
            sum += Math.abs(i-remain.get(remainIdx++));
        }
        System.out.println(sum);
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
