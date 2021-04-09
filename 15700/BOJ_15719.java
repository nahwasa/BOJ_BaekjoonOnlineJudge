import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[80000000];
        System.in.read(buffer, 0, buffer.length);
        int n = getNextInt(buffer);
        long sum = (n-1) * (long)n / 2;
        while (n-->0) sum -= getNextInt(buffer);
        System.out.println(-sum);
    }

    static int bufferIdx = 0;
    private static int getNextInt(byte[] buffer) {
        while (buffer[bufferIdx] == 10 || buffer[bufferIdx] == 32) bufferIdx++;
        int res = 0;
        while (buffer[bufferIdx] >= '0') {
            res = res*10 + buffer[bufferIdx++]-'0';
        }
        return res;
    }
}
