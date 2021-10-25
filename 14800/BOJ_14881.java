import java.io.DataInputStream;
import java.io.IOException;
public class Main {
    private static StringBuilder answer = new StringBuilder();

    private static void print(boolean yes) {
        if (yes) answer.append('Y').append('E').append('S').append('\n');
        else answer.append('N').append('O').append('\n');
    }

    private static void print() { print(true); }

    private static void flush() {
        System.out.println(answer);
    }

    private static int gcd(int a, int b) {
        int r = -1;
        while (r!=0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    private static void solution() throws Exception {
        int t = nextInt();
        while (t-->0) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            int gcd = gcd(a,b);
            int max = a>b?a:b;

            if (max>=c && (a==c || b==c || c%gcd==0 || gcd == 1)) print();
            else print(false);
        }
        flush();
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
