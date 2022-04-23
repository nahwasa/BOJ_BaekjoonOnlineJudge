import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    class Node implements Comparable<Node> {    // min heap
        int num;
        long t, g;
        public Node(int num, long t, long g) {
            this.num = num;
            this.t = t;
            this.g = g;
        }
        @Override
        public int compareTo(Node o) {
            if (this.t == o.t) {
                return o.g==this.g?0 : (o.g<this.g ? -1 : 1);
            }
            return this.t==o.t?0 : (this.t<o.t ? -1 : 1);
        }
    }

    class V implements Comparable<V> {  // max heap
        long t, g;
        public V(long t, long g) {
            this.t = t;
            this.g = g;
        }
        public boolean chk(long t, long g) {
            if (this.t > t || this.t == t && this.g < g) return true;
            return false;
        }
        public boolean chk(Node node) {
            if (this.t > node.t || this.t == node.t && this.g <= node.g) return true;
            return false;
        }
        @Override
        public int compareTo(V o) {
            if (this.t == o.t) {
                return o.g==this.g?0 : (o.g<this.g ? -1 : 1);
            }
            return this.t==o.t?0 : (this.t>o.t ? -1 : 1);
        }
    }

    private String getAnswer(int tc, int n, ArrayList<int[]>[] edges) {
        PriorityQueue<V>[] v = new PriorityQueue[n+1];
        for (int i = 1; i <= n; i++) v[i] = new PriorityQueue<>(2);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));
        v[1].add(new V(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (v[cur.num].size() == 2 && !v[cur.num].peek().chk(cur)) continue;
            ArrayList<int[]> edge = edges[cur.num];
            for (int i = 0; i < edge.size(); i++) {
                int[] tmp = edge.get(i);
                int next = tmp[0];
                long nextT = cur.t+tmp[1];
                long nextG = cur.g+tmp[2];
                if (v[next].size() < 2) {
                    v[next].add(new V(nextT, nextG));
                    pq.add(new Node(next, nextT, nextG));
                    continue;
                }
                if (v[next].peek().chk(nextT, nextG)) {
                    v[next].poll();
                    v[next].add(new V(nextT, nextG));
                    pq.add(new Node(next, nextT, nextG));
                    continue;
                }
            }
        }
        return String.format("Game #%d: Suckzoo ends game in time %d, earning %d garnet(s).\n", tc, v[n].peek().t, v[n].peek().g);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<int[]>[] edges = new ArrayList[n+1];
            for (int i = 1; i <= n ; i++) edges[i] = new ArrayList<>();
            while (m-->0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                edges[x].add(new int[]{y,t,g});
                edges[y].add(new int[]{x,t,g});
            }
            String answer = getAnswer(tc, n, edges);
            sb.append(answer);
            System.gc();
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
