import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int max = 0;
    private int n, k;
    private int[] arr;

    private void dfs(int cnt, int num) {
        if (cnt == 8) {
            return;
        }

        num *= 10;
        if (num >= n)
            return;

        for (int i = 0; i < k; i++) {
            int tmp = num + arr[i];
            if (tmp > n) continue;
            if (tmp > max) max = tmp;
            dfs(cnt+1, tmp);
        }
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
