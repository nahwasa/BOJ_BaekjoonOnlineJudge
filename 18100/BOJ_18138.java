import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int n, m;
    private static int[] nArr, mArr, owner;
    private static ArrayList<Integer>[] edge;
    private static boolean[] v;

    private static void init() throws Exception {
        n = nextInt();
        m = nextInt();

        nArr = new int[n];
        mArr = new int[m];

        edge = new ArrayList[n];
        for (int i = 0; i < n; i++) edge[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) nArr[i] = nextInt();
        for (int i = 0; i < m; i++) mArr[i] = nextInt();
    }

    private static void makeEdge() {
        for (int i = 0; i < n; i++) {
            int cur = nArr[i];
            double standard1 = cur/2f;
            double standard2 = cur*3/4f;
            int standard3 = cur;
            double standard4 = cur*5/4f;

            for (int j = 0; j < m; j++) {
                double target = mArr[j];
                if (standard1<=target && target<=standard2 || standard3<=target && target<=standard4)
                    edge[i].add(j);
            }
        }
    }

    private static boolean matching(int num) {
        ArrayList<Integer> e = edge[num];
        for (int i = 0; i < e.size(); i++) {
            int target = e.get(i);
            if (v[target]) continue;
            v[target] = true;

            if (owner[target] == -1 || matching(owner[target])) {
                owner[target] = num;
                return true;
            }
        }

        return false;
    }

    private static void solution() throws Exception {
        init();
        makeEdge();

        nArr = mArr = null; // only need for 'makeEdge'

        owner = new int[m];
        Arrays.fill(owner, -1);

        for (int i = 0; i < n; i++) {
            v = new boolean[m];
            matching(i);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (owner[i] != -1)
                answer++;
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
