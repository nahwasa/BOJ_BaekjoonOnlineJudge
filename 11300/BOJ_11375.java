import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int n, m;
    private static ArrayList<Integer>[] edge;
    private static boolean[] v;
    private static int[] matched;

    private static boolean matching(int num) {
        for (int cur : edge[num]) {
            if (v[cur]) continue;
            v[cur] = true;

            if (matched[cur] == -1 || matching(matched[cur])) {
                matched[cur] = num;
                return true;
            }
        }
        return false;
    }

    private static void solution() throws Exception {
        n = nextInt();
        m = nextInt();

        edge = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            edge[i] = new ArrayList<>();

        matched = new int[m+1];
        Arrays.fill(matched, -1);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = nextInt();
            while (tmp-->0)
                edge[i].add(nextInt());

            v = new boolean[m+1];
            answer += matching(i)?1:0;
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
