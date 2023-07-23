import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int n;
    List<Integer>[] edges;
    private void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        int ith = 0;
        List<Order> orders = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 2) {
                sb.append(isReachable(a, b) ? 1 : 0).append('\n');
                continue;
            }

            int curIth = ++ith;
            for (Order order : orders) {
                if (order.a < a && a < order.b || order.a < b && b < order.b)
                    edges[curIth].add(order.ith);
                if (a < order.a && order.a < b || a < order.b && order.b < b)
                    edges[order.ith].add(curIth);
            }
            orders.add(new Order(curIth, a, b));
        }

        System.out.print(sb);
    }

    private boolean isReachable(final int from, final int to) {
        boolean[] v = new boolean[n+1];
        v[from] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(from);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : edges[cur]) {
                if (next == to) return true;

                if (v[next]) continue;
                v[next] = true;

                q.add(next);
            }
        }
        return false;
    }
}

class Order {
    int ith, a, b;
    public Order(int ith, int a, int b) {
        this.ith = ith;
        this.a = a;
        this.b = b;
    }
}
