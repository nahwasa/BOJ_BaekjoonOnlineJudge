import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int b;
    double dist;
    public Edge(int b, double dist) {
        this.b = b;
        this.dist = dist;
    }
}

public class Main {
    private double getDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }

        ArrayList<Edge>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = getDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
                edges[i].add(new Edge(j, dist));
                edges[j].add(new Edge(i, dist));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.dist > o2.dist) return 1;
                else if (o1.dist < o2.dist) return -1;
                return 0;
            }
        });
        boolean[] v = new boolean[n];
        pq.add(new Edge(0, 0.0));

        double answer = 0.0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (v[cur.b]) continue;
            v[cur.b] = true;
            answer += cur.dist;

            for (Edge next : edges[cur.b]) {
                if (!v[next.b]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
