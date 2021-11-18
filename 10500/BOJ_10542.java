import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main extends FastInput {
    private int solve(int n, int[] choice, ArrayList<Integer> remain) {
        int answer = 0;
        int[] state = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();

        while (remain.size() != 0) {
            boolean[] isCitizen = new boolean[n+1];
            int cnt = 0;
            for (int i = 0; i < remain.size(); i++) {
                int num = remain.get(i);
                int to = choice[num];
                if (!isCitizen[to] && state[to] == 0) {
                    cnt++;
                    isCitizen[to] = true;
                }
            }

            if (cnt == remain.size()) {
                state[remain.get(0)] = 1;
                ArrayList<Integer> remainTmp = new ArrayList<>();
                for (int i = 0; i < remain.size(); i++) {
                    int num = remain.get(i);
                    if (state[num] == 0) {
                        remainTmp.add(num);
                    }
                }
                remain = remainTmp;
                continue;
            }

            for (int i = 0; i < remain.size(); i++) {
                int num = remain.get(i);
                if (!isCitizen[num]) {
                    state[num] = -1;
                    q.add(num);
                }
            }

            answer += q.size();

            while (!q.isEmpty()) {
                int to = choice[q.poll()];
                state[to] = 1;
            }

            ArrayList<Integer> remainTmp = new ArrayList<>();
            for (int i = 0; i < remain.size(); i++) {
                int num = remain.get(i);
                if (state[num] == 0) {
                    remainTmp.add(num);
                }
            }
            remain = remainTmp;
        }
        return answer;
    }

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
        parents[h] += parents[l];
        parents[l] = h;
    }

    private void initDisjointSet(int n) {
        parents = new int[n+1];
        Arrays.fill(parents, -1);
    }


    private void solution() throws Exception {
        int n = nextInt();
        int[] choice = new int[n+1];
        initDisjointSet(n);

        for (int i = 1; i <= n; i++) {
            choice[i] = nextInt();
            union(i, choice[i]);
        }

        ArrayList<Integer>[] remain = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            int findNum = find(i);
            if (remain[findNum] == null)
                remain[findNum] = new ArrayList<>();
            remain[findNum].add(i);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (remain[i] == null) continue;
            answer += solve(n, choice, remain[i]);
        }

        System.out.println(answer);
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
