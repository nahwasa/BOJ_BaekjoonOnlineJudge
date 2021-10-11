import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private static final String ANSWER_YES = "YES";
    private static final String ANSWER_NO = "NO";

    private static boolean[][] receiveInput(int n) throws Exception {
        boolean[][] tmp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = nextChar() == 'N' ? false : true;
            }
        }
        return tmp;
    }

    private static ArrayList<Integer>[] removeDoublyEdge(int n, boolean[][] baseEdge) {
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (baseEdge[i][j] && !baseEdge[j][i])
                    edges[i].add(j);
            }
        }
        return edges;
    }

    private static boolean isCycleExist(int n, ArrayList<Integer>[] edges) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            boolean[] v = new boolean[n];
            int start = i;
            stk.add(i);
            v[i] = true;
            while (!stk.isEmpty()) {
                int cur = stk.pop();
                for (int next : edges[cur]) {
                    if (next == start) {
                        return true;
                    }
                    if (v[next]) continue;
                    v[next] = true;
                    stk.add(next);
                }
            }
        }
        return false;
    }

    private static void solution() throws Exception {
        int n = nextInt();
        boolean[][] baseEdge = receiveInput(n);
        ArrayList<Integer>[] edges = removeDoublyEdge(n, baseEdge);
        String answer = isCycleExist(n, edges) ? ANSWER_NO : ANSWER_YES;
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 101;
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

    private static char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char)c;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
