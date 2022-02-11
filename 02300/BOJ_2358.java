import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int[] rArr = new int[100000];
        int[] cArr = new int[100000];
        HashMap<Integer, Integer> rComp = new LinkedHashMap<>();
        HashMap<Integer, Integer> cComp = new LinkedHashMap<>();
        int rCnt = 0, cCnt = 0;

        while (n-->0) {
            int r = nextInt();
            int c = nextInt();
            if (!rComp.containsKey(r)) rComp.put(r, rCnt++);
            if (!cComp.containsKey(c)) cComp.put(c, cCnt++);
            rArr[rComp.get(r)]++;
            cArr[cComp.get(c)]++;
        }

        long answer = 0;
        for (int i = 0; i < rCnt; i++) answer += rArr[i]>=2?1:0;
        for (int i = 0; i < cCnt; i++) answer += cArr[i]>=2?1:0;
        System.out.println(answer);
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
