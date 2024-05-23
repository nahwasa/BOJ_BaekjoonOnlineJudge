import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int k, n;
    Set<Integer>[] friends;

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        if (n < k) {
            System.out.println(-1);
            return;
        }

        friends = new Set[n+1];
        for (int i = 1; i <= n; i++) friends[i] = new HashSet<>();

        while (f-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        int[] selected = new int[k];
        if (!dfs(0, 0, selected)) {
            System.out.println(-1);
        }
    }

    private boolean dfs(int cnt, int bf, int[] selected) {
        if (cnt == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selected.length; i++) sb.append(selected[i]).append('\n');
            System.out.print(sb);
            return true;
        }

        for (int i = bf+1; i <= n; i++) {
            boolean canBeFriend = true;
            for (int j = 0; j < cnt; j++) {
                if (!friends[i].contains(selected[j])) {
                    canBeFriend = false;
                    break;
                }
            }
            if (!canBeFriend) continue;

            selected[cnt] = i;
            if (dfs(cnt+1, i, selected)) return true;
        }

        return false;
    }
}
