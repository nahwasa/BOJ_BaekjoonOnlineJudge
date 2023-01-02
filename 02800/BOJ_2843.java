import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Query {
    int op, x;
    public Query(int op, int x) {
        this.op = op;
        this.x = x;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int OP_ERASE = 2;
    private static final int OP_QUERY = 1;
    private static final int UF_ROOT = -1;
    private static final int UF_CYCLE = -2;

    int[] parents;
    boolean[] cycle;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private boolean isCycle(int a) {
        return parents[find(a)] == UF_CYCLE;
    }

    private int find(int a) {
        if (parents[a] < 0)
            return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) {
            parents[b] = UF_CYCLE;
            return;
        }
        parents[a] = b;
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        cycle = new boolean[n+1];
        Arrays.fill(parents, UF_ROOT);
        int[] edge = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            edge[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());
        Query[] queries = new Query[q];
        HashSet<Integer> except = new HashSet<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            queries[i] = new Query(op, x);
            if (op == OP_ERASE)
                except.add(x);
        }

        for (int i = 1; i <= n; i++) {
            if (except.contains(i) || edge[i] == 0) continue;
            union(i, edge[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = q-1; i >= 0; i--) {
            if (queries[i].op == OP_QUERY) {
                answer.add(isCycle(queries[i].x) ? UF_CYCLE : find(queries[i].x));
            } else {
                int a = queries[i].x;
                int b = edge[a];
                if (b!=0)
                    union(a, b);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = answer.size()-1; i >= 0; i--) {
            sb.append(answer.get(i) == UF_CYCLE ? "CIKLUS" : answer.get(i)).append('\n');
        }
        System.out.print(sb);
    }
}
