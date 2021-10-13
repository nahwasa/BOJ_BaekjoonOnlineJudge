import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            String s = nextLine();
            if (s.length() == 0) break;

            sb.append('C').append('a').append('s').append('e').append(' ').append(tc++).append(':').append(' ');
            switch(s.charAt(1)) {
                case ' ' : sb.append('U').append('N').append('I').append('Q').append('U').append('E').append('\n'); continue;
                case '#' : sb.append((char)((s.charAt(0)+1-'A')%('G'-'A'+1)+'A')).append('b'); for(int i=2;i<s.length();i++) sb.append(s.charAt(i)); sb.append('\n'); break;
                case 'b' : sb.append((char)(('G'-'A'+1+s.charAt(0)-1-'A')%('G'-'A'+1)+'A')).append('#'); for(int i=2;i<s.length();i++) sb.append(s.charAt(i)); sb.append('\n'); break;
            }
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
