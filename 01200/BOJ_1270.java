import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        initFI();
        int n = nextInt();
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            System.gc();
            int t = nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            int limit = t/2;
            int idx = 0;
            int[] cnt = new int[100000];
            while (t-->0) {
                long tmp = nextLong();
                int cur = tmp == Integer.MAX_VALUE + 1L ? -1 : (int)tmp;
                if (!hm.containsKey(cur)) {
                    hm.put(cur, idx);
                    cnt[idx]++;
                    idx+=1;
                    continue;
                }
                cnt[hm.get(cur)]++;
            }
            boolean chk = false;
            for (Integer key : hm.keySet()) {
                if (cnt[hm.get(key)] > limit) {
                    chk = true;
                    sb.append(key == -1 ? 2147483648L : key).append('\n');
                    break;
                }
            }
            if (chk) continue;
            sb.append('S').append('Y').append('J').append('K').append('G').append('W').append('\n');
        }
        System.out.println(sb);
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

    private static long nextLong() throws IOException {
        long ret = 0;
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
