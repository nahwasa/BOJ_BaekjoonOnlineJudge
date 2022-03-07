import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int n;
    ArrayList<Integer>[] fArr, eArr;
    boolean[] fv, ev;

    private void eDfs(int root, int s, int cnt) {
        if (cnt == 2) {
            fArr[root].add(s);
            return;
        }

        for (Integer next : eArr[s]) {
            if (ev[next]) continue;
            ev[next] = true;
            eDfs(root, next, cnt+1);
        }
    }

    private void dfs(int s) {
        for (Integer next : fArr[s]) {
            if (fv[next]) continue;
            fv[next] = true;
            dfs(next);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        fArr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) fArr[i] = new ArrayList<>();
        eArr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) eArr[i] = new ArrayList<>();

        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (c) {
                case 'E' : eArr[a].add(b); eArr[b].add(a); break;
                case 'F' : fArr[a].add(b); fArr[b].add(a); break;
            }
        }

        for (int i = 1; i <= n; i++) {
            ev = new boolean[n+1];
            eDfs(i, i, 0);
        }


        fv = new boolean[n+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!fv[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
