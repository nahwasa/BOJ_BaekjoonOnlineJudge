import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] edges = new List[n+1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-->0) {
                int cur = Integer.parseInt(st.nextToken());
                edges[i].add(cur);
                edges[cur].add(i);
            }
        }

        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();

        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (v[i] != 0) continue;
            v[i] = 1;
            team1.add(i);

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : edges[cur]) {
                    if (v[next] != 0) continue;

                    if ((v[next] = 3-v[cur])==1) team1.add(next);
                    else team2.add(next);

                    q.add(next);
                }
            }
        }

        if (team2.isEmpty()) {
            team1.remove(0);
            team2.add(1);
        }

        Collections.sort(team1);
        Collections.sort(team2);

        StringBuilder sb = new StringBuilder();
        sb.append(team1.size()).append('\n');
        for (int cur : team1) {
            sb.append(cur).append(' ');
        }
        sb.append('\n');
        sb.append(team2.size()).append('\n');
        for (int cur : team2) {
            sb.append(cur).append(' ');
        }
        System.out.println(sb);
    }
}
