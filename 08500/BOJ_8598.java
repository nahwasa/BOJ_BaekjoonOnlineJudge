import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;

class Pos {
    int r, c;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main extends FastInput {
    private static final int[] DR = {1,1,-1,-1,2,2,-2,-2};
    private static final int[] DC = {2,-2,2,-2,1,-1,1,-1};


    private int bfs(Queue<Pos> q, Pos goal, int[][] v, int r, int c) {
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (cur.r==goal.r && cur.c==goal.c) {
                return v[goal.r][goal.c]-1;
            }

            for (int d = 0; d < 8; d++) {
                int nr = cur.r+DR[d];
                int nc = cur.c+DC[d];

                if (nr<0||nr>=r||nc<0||nc>=c||v[nr][nc]!=0) continue;
                v[nr][nc] = v[cur.r][cur.c]+1;
                q.add(new Pos(nr, nc));
            }
        }
        return -1;
    }

    private void solution() throws Exception {
        int r = nextInt();
        int c = nextInt();

        Queue<Pos> q = new ArrayDeque<>();
        Pos goal = null;
        int[][] v = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                switch(nextChar()) {
                    case 'z' : q.add(new Pos(i, j)); v[i][j]=1; break;
                    case 'n' : goal = new Pos(i, j); break;
                    case 'x' : v[i][j] = -1; break;
                }
            }
        }

        int answer = bfs(q, goal, v, r, c);
        System.out.println(answer==-1?"NIE":answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret;
    }

    protected static char nextChar() throws IOException {
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
