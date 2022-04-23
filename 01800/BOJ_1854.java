import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    class Node implements Comparable<Node> {    // min heap
        int num, c;
        public Node(int num, int t) {
            this.num = num;
            this.c = t;
        }
        @Override
        public int compareTo(Node o) {
            return this.c-o.c;
        }
    }

    private void solve(int n, int k, ArrayList<int[]>[] edges) {
        PriorityQueue<Integer>[] v = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) v[i] = new PriorityQueue<>(k, Collections.reverseOrder());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        v[1].add(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (v[cur.num].size() == k && v[cur.num].peek()<cur.c) continue;
            ArrayList<int[]> edge = edges[cur.num];
            for (int i = 0; i < edge.size(); i++) {
                int[] tmp = edge.get(i);
                int next = tmp[0];
                int nextC = cur.c +tmp[1];
                if (v[next].size() < k) {
                    v[next].add(nextC);
                    pq.add(new Node(next, nextC));
                    continue;
                }
                if (v[next].peek()>nextC) {
                    v[next].poll();
                    v[next].add(nextC);
                    pq.add(new Node(next, nextC));
                    continue;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (v[i].size() < k)
                sb.append(-1).append('\n');
            else
                sb.append(v[i].peek()).append('\n');
        }
        System.out.print(sb);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b,c});
        }
        solve(n, k, edges);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
