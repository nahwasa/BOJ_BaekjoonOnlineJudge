import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Main extends FastInput {
    private void solution() throws Exception {
        int k = nextInt();
        StringBuilder sb = new StringBuilder();
        while (k-->0) {
            int v = nextInt();
            int e = nextInt();
            ArrayList<Integer>[] edges = new ArrayList[v+1];
            for (int i = 1; i <= v; i++) edges[i] = new ArrayList<>();
            boolean[] chk = new boolean[v+1];
            while(e-->0) {
                int a = nextInt();
                int b = nextInt();
                chk[a] = chk[b] = true;
                edges[a].add(b);
                edges[b].add(a);
            }
            Boolean[] arr = new Boolean[v+1];
            boolean answer = true;
            for (int i = 1; i <= v && answer; i++) {
                if (arr[i]!=null || !chk[i]) continue;
                Stack<Integer> stk = new Stack<>();
                stk.add(i);
                arr[i] = true;
                while(!stk.isEmpty() && answer) {
                    int cur = stk.pop();
                    for (int j = 0; j < edges[cur].size(); j++) {
                        int next = edges[cur].get(j);
                        if (arr[next] == null) {
                            arr[next] = !arr[cur];
                            stk.add(next);
                        } else if (arr[next] == arr[cur]) {
                            answer = false;
                            break;
                        }
                    }
                }
            }
            sb.append(answer?"YES\n":"NO\n");
        }
        System.out.print(sb);
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
