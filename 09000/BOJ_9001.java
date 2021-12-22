import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Rectangle {
    int x1, y1, x2, y2;
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public boolean contain(Rectangle rec) {
        int tmpX = this.x1;
        int tmpY = this.y1;
        if (rec.x1 <= tmpX && tmpX <= rec.x2 && rec.y1 <= tmpY && tmpY <= rec.y2) return true;
        tmpY = this.y2;
        if (rec.x1 <= tmpX && tmpX <= rec.x2 && rec.y1 <= tmpY && tmpY <= rec.y2) return true;
        tmpX = this.x2;
        if (rec.x1 <= tmpX && tmpX <= rec.x2 && rec.y1 <= tmpY && tmpY <= rec.y2) return true;
        tmpY = this.y1;
        if (rec.x1 <= tmpX && tmpX <= rec.x2 && rec.y1 <= tmpY && tmpY <= rec.y2) return true;

        tmpX = rec.x1;
        tmpY = rec.y1;
        if (x1 <= tmpX && tmpX <= x2 && y1 <= tmpY && tmpY <= y2) return true;

        if (rec.x1 <= x1 && x1 <= rec.x2 && y1 <= rec.y1 && rec.y2 <= y2) return true;
        if (x1 <= rec.x1 && rec.x1 <= x2 && rec.y1 <= y1 && y2 <= rec.y2) return true;
        if (rec.y1 <= y1 && y1 <= rec.y2 && x1 <= rec.x1 && rec.x2 <= x2) return true;
        if (y1 <= rec.y1 && rec.y1 <= y2 && rec.x1 <= x1 && x2 <= rec.x2) return true;

        return false;
    }
}

public class Main extends FastInput {
    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = parents[a]<parents[b] ? a:b;
        int l = parents[a]<parents[b] ? b:a;
        parents[a] += parents[b];
        parents[b] = a;
    }

    private void solution() throws Exception {
        int t = nextInt();
        StringBuilder answer = new StringBuilder();
        while (t-->0) {
            int n = nextInt();
            parents = new int[n];
            Arrays.fill(parents, -1);

            ArrayList<Rectangle> arr = new ArrayList<>(n);
            int arrIdx = 0;
            while (n-->0) {
                Rectangle cur = new Rectangle(nextInt(), nextInt(), nextInt(), nextInt());
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).contain(cur)) {
                        union(i, arr.size());
                    }
                }
                arr.add(cur);
                arrIdx++;
            }

            int cnt = 0;
            for (int i = 0; i < parents.length; i++) {
                find(i);
                if (parents[i] < 0) cnt++;
            }
            answer.append(cnt).append('\n');
        }
        System.out.print(answer);
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

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
