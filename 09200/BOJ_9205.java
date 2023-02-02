import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int DISTANCE_LIMIT = 1000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            boolean result = main.solution();
            sb.append(result ? "happy" : "sad");
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public boolean solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        List<Pos> list = new ArrayList<>();
        list.add(start);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        Pos end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        list.add(end);

        List<Integer>[] edges = new ArrayList[list.size()];
        for (int i = 0; i < list.size(); i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                Pos a = list.get(i);
                Pos b = list.get(j);
                if (Math.abs(a.x-b.x)+Math.abs(a.y-b.y) > DISTANCE_LIMIT) continue;

                edges[i].add(j);
                edges[j].add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[list.size()];
        q.add(0);
        v[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == list.size()-1) {
                return true;
            }
            for (int next : edges[cur]) {
                if (v[next]) continue;
                v[next] = true;
                q.add(next);
            }
        }
        return false;
    }
}
