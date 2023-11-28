import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Pillar[] arr = new Pillar[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        StringTokenizer pst = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(pst.nextToken());
        while (m-->0) arr[Integer.parseInt(st.nextToken())].marking(Integer.parseInt(pst.nextToken()));

        List<Integer>[] edges = findEdgesBaseOnR0(arr, n, r);
        List<Integer> startPoint = findStartPoint(arr, n);

        int answer = startPoint.size();
        boolean[] v = new boolean[n+1];
        for (int cur : startPoint) v[cur] = true;
        Queue<Integer> q = new ArrayDeque<>(startPoint);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : edges[cur]) {
                if (v[next]) continue;
                v[next] = true;

                answer++;
                q.add(next);
            }
        }

        System.out.println(answer);
    }

    private List<Integer> findStartPoint(final Pillar[] arr, final int n) {
        boolean[] chk = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (arr[i].r == -1) continue;
            chk[i] = true;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                if (reachable(arr[i], arr[j], Math.max(arr[i].r, arr[j].r)))
                    chk[j] = true;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!chk[i])
                ans.add(i);
        }

        return ans;
    }

    private List<Integer>[] findEdgesBaseOnR0(Pillar[] arr, int n, int r) {
        List<Integer>[] edges = new List[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (!reachable(arr[i], arr[j], r)) continue;

                edges[i].add(j);
                edges[j].add(i);
            }
        }

        return edges;
    }

    private boolean reachable(Pillar a, Pillar b, int r) {
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y) <= r*r;
    }
}

class Pillar {
    int x, y, r = -1;

    public Pillar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void marking(int dist) {
        this.r = Math.max(this.r, dist);
    }
}
