import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Block {
    int a, b;
    public Block(int a, int b) {this.a=a; this.b=b;}
}

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();
        int[] color = new int[n];
        Block[] arr = new Block[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Block(nextInt(), nextInt());
            color[i] = arr[i].b;
        }
        Arrays.sort(arr, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return o1.a - o2.a;
            }
        });

        for (int i = 0; i < n; i++) {
            if (color[i] != arr[i].b) {
                System.out.println("N");
                return;
            }
        }
        System.out.println("Y");
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
