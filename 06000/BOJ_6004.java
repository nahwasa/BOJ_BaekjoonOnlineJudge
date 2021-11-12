import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

class Pos {
    int r, c, d;
    public Pos(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

public class Main {
    private int[] dr = {-2, -1, -2, -1,  2,  1, 2, 1};
    private int[] dc = {-1, -2,  1,  2, -1, -2, 1, 2};


    private void solution() throws Exception {
        int c = nextInt();
        int r = nextInt();
        boolean[][] v = new boolean[r][c];
        Pos s = null;
        Pos e = null;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                switch(nextChar()) {
                    case 'K' : s = new Pos(i,j,0); break;
                    case 'H' : e = new Pos(i,j,0); break;
                    case '*' : v[i][j] = true;
                }
            }
        }

        Queue<Pos> q = new ArrayDeque<>();
        v[s.r][s.c] = true;
        q.add(s);
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (cur.r==e.r&&cur.c==e.c) {
                System.out.println(cur.d);
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if (nr<0||nr>=r||nc<0||nc>=c||v[nr][nc]) continue;
                v[nr][nc]=true;
                q.add(new Pos(nr,nc,cur.d+1));
            }
        }
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
