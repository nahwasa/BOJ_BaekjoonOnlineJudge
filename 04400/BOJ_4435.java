import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static final int[] GRADE1 = {1,2,3,3,4,10};
    private static final int[] GRADE2 = {1,2,2,2,3,5,10};
    private static final String RES1 = "Good triumphs over Evil";
    private static final String RES2 = "Evil eradicates all trace of Good";
    private static final String RES3 = "No victor on this battle field";


    public static void main(String[] args) throws Exception {
        initFI();
        int tc = nextInt();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            int sum = 0;
            for (int k = 0; k < 6; k++) sum += nextInt() * GRADE1[k];
            for (int k = 0; k < 7; k++) sum -= nextInt() * GRADE2[k];
            res.append('B').append('a').append('t').append('t').append('l').append('e').append(' ')
                    .append(i).append(':').append(' ').append(sum == 0 ? RES3 : sum > 0 ? RES1 : RES2).append('\n');
        }
        System.out.println(res);
    }

    // Fast IO
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
