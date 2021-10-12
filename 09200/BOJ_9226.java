import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static int chk(String s) {
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'a' : case 'e' : case 'i' : case 'o' : case 'u' :
                    return i;
            }
        }
        return -1;
    }

    private static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = nextLine();
            if (s.contains("#")) break;

            int idx = chk(s);
            if (idx <= 0) {
                sb.append(s).append("ay").append('\n');
                continue;
            }

            sb.append(s.substring(idx)).append(s.substring(0, idx)).append("ay").append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int MAX_CHAR_LEN_FOR_NEXT_LINE = 21;
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
