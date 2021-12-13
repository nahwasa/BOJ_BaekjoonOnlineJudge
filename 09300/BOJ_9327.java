import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main extends FastInput {
    private void solution() throws Exception {
        int tc = nextInt();
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = nextInt();
            int e = nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            HashSet<Integer> hs = new HashSet<>();
            list.add(0);

            while (n-->0) {
                int cur = nextInt() * 2;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    int tmp = list.get(i) + cur;
                    if (!hs.contains(tmp)) {
                        hs.add(tmp);
                        list.add(tmp);
                    }
                }
            }

            Collections.sort(list);
            boolean isFull = true;
            for (int i : list) {
                if (i >= e) {
                    sb.append(i/2).append('\n');
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                sb.append("FULL").append('\n');
            }
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
