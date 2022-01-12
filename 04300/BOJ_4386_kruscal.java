import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int a, b;
    double dist;
    public Edge(int a, int b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }
}

public class Main {
    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        int h = parents[a] < parents[b] ? a : b;
        int l = parents[a] < parents[b] ? b : a;
        parents[h] += parents[l];
        parents[l] = h;
        return true;
    }

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

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = getDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.dist > o2.dist) return 1;
                else if (o1.dist < o2.dist) return -1;
                return 0;
            }
        });

        parents = new int[n];
        Arrays.fill(parents, -1);

        double answer = 0.0;
        for (int i = 0; i < edges.size(); i++) {
            Edge cur = edges.get(i);
            if (union(cur.a, cur.b)) {
                answer += cur.dist;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
