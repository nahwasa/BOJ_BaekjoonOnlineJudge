import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class Main extends FastInput {
    private void solution() throws Exception {
        int q = nextInt();
        int mod = nextInt();
        Stack<Integer>[] arr = new Stack[mod];
        for (int i = 0; i < mod; i++) arr[i] = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (q-->0) {
            switch (nextInt()) {
                case 1 :
                    int num = nextInt();
                    arr[num%mod].push(idx++);
                    break;
                case 2 :
                    for (int i = 0; i < mod; i++) {
                        if (!arr[i].isEmpty() && arr[i].peek() == idx-1) {
                            arr[i].pop();
                            idx--;
                            break;
                        }
                    }
                    break;
                case 3 :
                    int min = Integer.MAX_VALUE;
                    for (int i = 0; i < mod; i++) {
                        if (arr[i].isEmpty()) {
                            min = -1;
                            break;
                        }
                        if (arr[i].peek() < min) {
                            min = arr[i].peek();
                        }
                    }
                    sb.append(min==-1?min:idx-min).append('\n');
                    break;
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
    private static final int DEFAULT_BUFFER_SIZE = 1 << 10;
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
