import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeSet;

public class Main extends FastInput {
    class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void solution() throws Exception {
        int n = nextInt();
        TreeSet<Integer>[] tsArr = new TreeSet[n+1];

        Pos[] posArr = new Pos[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            posArr[i] = new Pos(x, y);
            if (tsArr[y] == null) {
                tsArr[y] = new TreeSet<>();
                tsArr[y].add(-1000000);
                tsArr[y].add(1000000);
            }
            tsArr[y].add(x);
        }

        int sum = 0;
        for (Pos pos : posArr) {
            sum += Math.min( Math.abs(pos.x - tsArr[pos.y].higher(pos.x)), Math.abs(pos.x - tsArr[pos.y].lower(pos.x)));
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
