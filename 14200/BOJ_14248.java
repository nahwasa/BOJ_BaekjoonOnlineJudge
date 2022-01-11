import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    boolean[] v;
    int cnt = 0, n;
    int[] arr;

    private void dfs(int s) {
        if (s<1||s>n||v[s]) return;

        v[s] = true;
        cnt++;
        dfs(s+arr[s]);
        dfs(s-arr[s]);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        v = new boolean[n+1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        dfs(s);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
