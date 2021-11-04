import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    private HashSet<Integer>[] colorChk;
    private int[] parents;
    private int[] color;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h]+=parents[l];
        parents[l] = h;
        colorChk[h].addAll(colorChk[l]);
    }

    private void solution() throws Exception {
        int n = nextInt();
        int q = nextInt();

        // input : parent node num & colors
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            arr[i] = nextInt();
        }
        color = new int[n+1];
        for (int i = 1; i <= n; i++) {
            color[i] = nextInt();
        }

        // input : queries
        ArrayList<Integer>[] queries = new ArrayList[n-1+q];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new ArrayList<>(2);
            queries[i].add(nextInt());
            queries[i].add(nextInt());
        }

        // init
        colorChk = new HashSet[n+1];
        for (int i = 1; i <= n; i++) {
            colorChk[i] = new HashSet<>();
            colorChk[i].add(color[i]);
        }
        parents = new int[n+1];
        Arrays.fill(parents, -1);

        // solve
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = queries.length-1; i >= 0; i--) {
            int x = queries[i].get(0);
            int a = queries[i].get(1);
            if (x == 1) {
                union(a, arr[a]);
            } else {
                answer.add(colorChk[find(a)].size());
            }
        }

        // print
        StringBuilder sb = new StringBuilder();
        for (int i = answer.size()-1; i >= 0; i--) {
            sb.append(answer.get(i)).append('\n');
        }
        System.out.print(sb);
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
