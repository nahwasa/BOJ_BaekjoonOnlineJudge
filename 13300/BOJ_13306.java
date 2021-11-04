import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0)
            return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h]+=parents[l];
        parents[l]=h;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int q = nextInt();

        // input: parent node num
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            arr[i] = nextInt();
        }

        // init union-find
        parents = new int[n+1];
        Arrays.fill(parents, -1);

        // input: queries
        ArrayList<Integer>[] query = new ArrayList[n-1+q];
        for (int i = 0; i < query.length; i++) {
            query[i] = new ArrayList<>(2);
            int x = nextInt();
            if (x == 1) {
                query[i].add(nextInt());
                query[i].add(nextInt());
            } else {
                query[i].add(nextInt());
            }
        }

        // solve
        ArrayList<Boolean> answer = new ArrayList<>();
        for (int i = query.length-1; i >= 0; i--) {
            ArrayList<Integer> cur = query[i];
            if (cur.size() == 1) {
                union(cur.get(0), arr[cur.get(0)]);
            } else {
                answer.add(find(cur.get(0))==find(cur.get(1)));
            }
        }

        // print
        StringBuilder sb = new StringBuilder();
        for (int i = answer.size()-1; i >= 0; i--) {
            if (answer.get(i)) sb.append('Y').append('E').append('S');
            else sb.append('N').append('O');
            sb.append('\n');
        }
        System.out.println(sb);
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
