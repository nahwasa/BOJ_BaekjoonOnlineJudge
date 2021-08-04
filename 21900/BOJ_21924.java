import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int a, b, cost;
    public Node(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
}

public class Main {
    private static int[] parents;
    private static StringTokenizer st;

    private static int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = a < b ? a : b;
        int l = a < b ? b : a;
        parents[h] += parents[l];
        parents[l] = h;
    }

    private static int nextInt() { return Integer.parseInt(st.nextToken()); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = nextInt();
        int m = nextInt();

        parents = new int[n];
        Arrays.fill(parents, -1);
        ArrayList<Node> arr = new ArrayList<>();
        long costSum = 0;
        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int tmp = 0;
            arr.add(new Node(nextInt()-1, nextInt()-1, tmp = nextInt()));
            costSum += tmp;
        }

        Collections.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < arr.size(); i++) {
            Node node = arr.get(i);
            int a = find(node.a);
            int b = find(node.b);
            if (a == b) continue;

            costSum -= node.cost;
            union(node.a, node.b);
        }

        int cnt = 0;
        for (int i = 0; i < parents.length; i++)
            if (parents[i] < 0) cnt++;
        System.out.println(cnt == 1 ? costSum : -1);
    }
}
