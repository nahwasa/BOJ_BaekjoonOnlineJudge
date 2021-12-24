import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pos implements Comparable<Pos> {
    int num, dist;
    public Pos(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pos o) {
        return this.dist - o.dist;
    }
}

public class Main extends FastInput {
    private static final int INF = 125*125*9+1;

    private int getNumOfAdjacent(int n, int curNum, int dir) {
        switch (dir) {
            case 0 : if (curNum-n >= 0)     return curNum-n; break;
            case 1 : if (curNum+n < n*n)      return curNum+n; break;
            case 2 : if (curNum%n!=0)       return curNum-1; break;
            case 3 : if (curNum%n!=n-1)     return curNum+1; break;
        }
        return -1;
    }

    private int getAnswer(int n, int[] arr) {
        int[] dist = new int[n*n];
        Arrays.fill(dist, INF);

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(0, arr[0]));
        dist[0] = arr[0];
        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            if (cur.dist > dist[cur.num]) continue;
            for (int dir = 0; dir < 4; dir++) {
                int next = getNumOfAdjacent(n, cur.num, dir);
                if (next == -1 || cur.dist + arr[next] >= dist[next]) continue;
                dist[next] = cur.dist + arr[next];
                pq.add(new Pos(next, dist[next]));
            }
        }

        return dist[n*n-1];
    }

    private void solution() throws Exception {
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = nextInt();
            if (n == 0) break;

            sb.append("Problem ").append(tc++).append(':').append(' ');
            int[] arr = new int[n*n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) arr[n*i+j] = nextInt();
            sb.append(getAnswer(n, arr)).append('\n');
        }
        System.out.println(sb);
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
