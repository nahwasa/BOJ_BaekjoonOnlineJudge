import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final long MAX_DIV_2 = 1000000000000000000l/2;
    private long[] answer, arr;
    ArrayList<Integer>[] edge;
    boolean[] v;
    int n;

    private boolean dfs(int s, int cnt) {
        answer[cnt] = arr[s];
        if (cnt == n-1) {
            return true;
        }

        for (int next : edge[s]) {
            if (v[next]) continue;
            v[next] = true;

            if (dfs(next, cnt+1)) return true;
            v[next] = false;
        }
        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new long[n];
        arr = new long[n];
        v = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        edge = new ArrayList[n];
        for (int i = 0; i < n; i++) edge[i] = new ArrayList<>();
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i]%3==0 && arr[i]/3==arr[j] || arr[i]<MAX_DIV_2 && arr[i]*2==arr[j]) {
                    edge[i].add(j);
                    cnt[j]++;
                }
            }
        }

        for (int targetCnt = 0; ; targetCnt++) {
            for (int i = 0; i < n; i++) {
                if (cnt[i] == targetCnt)
                    if (dfs(i, 0)) {
                        StringBuilder sb = new StringBuilder();
                        for (long tmp : answer)
                            sb.append(tmp).append(' ');
                        System.out.println(sb);
                        return;
                    }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
