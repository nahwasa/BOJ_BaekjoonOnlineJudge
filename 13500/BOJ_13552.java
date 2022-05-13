import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main extends FastInput {
    private long getPowOfDistance(int[] point, int x, int y, int z){
        int a = point[0]-x;
        int b = point[1]-y;
        int c = point[2]-z;
        return 1l*a*a+1l*b*b+1l*c*c;
    }
    private void solution() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
            arr[i][2] = nextInt();
        }
        int m = nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            int x = nextInt();
            int y = nextInt();
            int z = nextInt();
            int r = nextInt();
            long rPow = 1l*r*r;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (getPowOfDistance(arr[i], x, y, z) <= rPow) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
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
