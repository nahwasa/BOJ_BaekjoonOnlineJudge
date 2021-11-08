import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static final double PI = 3.1415927d;
    private static final int MILE_TO_INCH_DIV = 5280*12;
    private StringBuilder sb = new StringBuilder();
    private void print(int trip, double dist, double mph) {
        sb.append(String.format("Trip #%d: %.2f %.2f\n", trip, dist, mph));
    }
    private void flush() { System.out.print(sb); }

    private void solution() throws Exception {
        int trip = 1;
        while (true) {
            double a = nextDouble();
            int b = nextInt();
            double c = nextDouble();

            if (b == 0) break;

            double dist = PI*a*b/MILE_TO_INCH_DIV;
            double mph = 3600/c*dist;

            print(trip, dist, mph);

            trip++;
        }
        flush();
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
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static double nextDouble() throws IOException {
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
