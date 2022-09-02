import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b,c});
            edges[b].add(new int[]{a,c});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        boolean[] v = new boolean[n+1];
        pq.add(new int[]{1,0});
        int sum = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (v[cur[0]]) continue;
            v[cur[0]] = true;
            sum += cur[1];
            if (max < cur[1]) max = cur[1];
            for (int[] next : edges[cur[0]]) {
                if (!v[next[0]])
                    pq.add(next);
            }
        }
        System.out.println(sum-max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
