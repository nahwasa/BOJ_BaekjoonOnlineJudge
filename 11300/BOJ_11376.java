import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<Integer>[] e;
    private static int[] matched;
    private static boolean[] v;

    private static boolean matching(int n) {
        ArrayList<Integer> edge = e[n/2];
        for (int i = 0; i < edge.size(); i++) {
            int m = edge.get(i);
            if (v[m])
                continue;
            v[m] = true;

            if (matched[m] == -1 || matching(matched[m])) {
                matched[m] = n;
                return true;
            }
        }
        return false;
    }

    private static void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();

        e = new ArrayList[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int work = nextInt();
            while (work-->0)
                e[i].add(nextInt());
        }

        int answer = 0;
        matched = new int[m+1];
        Arrays.fill(matched, -1);
        v = new boolean[m+1];
        for (int i = 0; i < 2*n; i++) {
            if (matching(i)) {
                answer++;
                v = new boolean[m+1];
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 20;
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
