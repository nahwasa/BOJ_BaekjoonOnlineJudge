import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static boolean[] v;
    private static int[] matched;
    private static ArrayList<Integer>[] edge;

    private static boolean matching(int cur) {
        for (int next : edge[cur]) {
            if (v[next]) continue;
            v[next] = true;
            if (matched[next] == -1 || matching(matched[next])) {
                matched[next] = cur;
                return true;
            }
        }
        return false;
    }

    private static void solution() throws Exception {
        int tmp = nextInt();
        boolean[] already = new boolean[101];
        while (tmp-->0) already[nextInt()] = true;

        edge = new ArrayList[101];
        for (int i = 1; i <= 100; i++)
            edge[i] = new ArrayList<>();

        int n = nextInt();
        int idx = 0;
        boolean[] lecture = new boolean[101];
        while (n-->0) {
            int a = nextInt();
            int b = nextInt();
            for (int i = 0; i < b; i++) {
                int cur = nextInt();
                if (!already[cur])
                    lecture[cur] = true;
                for (int j = idx; j < idx + a; j++) {
                    edge[cur].add(j);
                }
            }
            idx+=a;
        }

        matched = new int[idx];
        Arrays.fill(matched, -1);

        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            v = new boolean[idx];
            if (!already[i]) continue;
            if (matching(i))
                cnt++;
        }
        boolean[] answer = new boolean[101];
        for (int i = 1; i <= 100; i++) {
            v = new boolean[idx];
            if (!lecture[i]) continue;
            if (matching(i)) {
                cnt++;
                answer[i] = true;
            }
        }

        if (cnt < idx) {
            System.out.println(-1);
            return;
        }

        cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            if (!answer[i]) continue;
            cnt++;
            sb.append(i).append(' ');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
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
