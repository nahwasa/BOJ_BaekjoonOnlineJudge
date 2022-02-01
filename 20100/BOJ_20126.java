import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

class Exam implements Comparable<Exam>{
    int x, y;

    public Exam(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Exam o) {
        if (this.x == o.x)
            return this.y - o.y;
        return this.x - o.x;
    }
}

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int s = nextInt();

        Exam[] arr = new Exam[n+2];
        arr[0] = new Exam(0, 0);
        for (int i = 1; i <= n; i++)
            arr[i] = new Exam(nextInt(), nextInt());
        arr[n+1] = new Exam(s, s);
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].x - (arr[i-1].x + arr[i-1].y) >= m) {
                System.out.println(arr[i-1].x + arr[i-1].y);
                return;
            }
        }
        System.out.println(-1);
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
