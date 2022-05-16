import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Node {
    int num;
    Node next;
    public Node(int num) {
        this.num = num;
        this.next = null;
    }
}
class LList {
    Node st, ed;
    public LList() {
        st = ed = null;
    }
    public boolean isEmpty() {return st==null;}
    public void add(int num) {
        Node tmp = new Node(num);
        if (isEmpty()) {
            st = ed = tmp;
        } else {
            ed.next = tmp;
            ed = tmp;
        }
    }
    public void concat(LList another) {
        if (another.isEmpty()) return;
        if (isEmpty()) {
            this.st = another.st;
            this.ed = another.ed;
        } else {
            this.ed.next = another.st;
            this.ed = another.ed;
        }
        another.st = another.ed = null;
    }
}

public class Main extends FastInput {
    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();
        LList[] list = new LList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new LList();
            list[i].add(i);
        }
        while (m-->0) {
            int u = nextInt();
            int v = nextInt();
            list[v].concat(list[u]);
        }
        int[] answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            LList tmp = list[i];
            if (tmp.isEmpty()) continue;
            Node it = tmp.st;
            while (it != null) {
                answer[it.num] = i;
                it = it.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static BufferedReader br;
    public static void main(String[] args) throws Exception {
        initFI();
//        initSI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 100010;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static BufferedReader br;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static void initSI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    protected static String nextLine() throws IOException {
        byte[] buf = new byte[MAX_CHAR_LEN_FOR_NEXT_LINE];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) break;
                continue;
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
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

    protected static long nextLong() throws IOException {
        long ret = 0;
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

    protected static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    protected static char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char)c;
    }

    protected static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
