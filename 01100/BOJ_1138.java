import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    private void solution() throws Exception {
        int n = nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = n; i > 0; i--)
            list.add(arr[i], i);
        Iterator<Integer> it = list.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next()).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
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
