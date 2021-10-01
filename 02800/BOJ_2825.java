import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static void solution() throws Exception {
        int n = Integer.parseInt(nextLine());
        int[] arr = new int[1<<10];
        while (n-->0) {
            String cur = nextLine();
            int bitMasking = 0;
            for (int i = 0; i < cur.length(); i++)
                bitMasking |= 1<<(cur.charAt(i) - '0');
            arr[bitMasking]++;
        }

        long answer = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++)
                if ((i&j)!=0)   answer += 1l * arr[i] * arr[j];
            if (arr[i] >= 2)
                answer += 1l * arr[i] * (arr[i]-1) / 2;
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

    private static String nextLine() throws IOException {
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

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
