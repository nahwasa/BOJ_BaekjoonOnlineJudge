import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int to, weight;
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    private int len;
    private ArrayList<Edge>[] edges;
    private int[] memoization;

    private void dfs(int idx, int weightSum) {
        if (memoization[idx] >= weightSum) return;
        memoization[idx] = weightSum;
        if (idx == len) {
            return;
        }
        for (Edge edge : edges[idx]) {
            dfs(edge.to, weightSum + edge.weight);
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        len = s.length();
        memoization = new int[len+1];
        Arrays.fill(memoization, -1);
        edges = new ArrayList[s.length()];
        for (int i = 0; i < s.length(); i++) {
            edges[i] = new ArrayList<>();
            edges[i].add(new Edge(i+1, 1));
        }
        StringTokenizer st;
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            String cur = st.nextToken();
            int weight = Integer.parseInt(st.nextToken());
            if (cur.length() >= weight) continue;
            for (int i = 0; i < len; ) {
                int idx = s.indexOf(cur, i);
                if (idx == -1) break;
                i = idx+cur.length();
                edges[idx].add(new Edge(i, weight));
            }
        }
        dfs(0, 0);
        System.out.println(memoization[len]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
