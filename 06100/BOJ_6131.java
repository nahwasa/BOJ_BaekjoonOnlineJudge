import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int LIMIT = 500;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= LIMIT; i++) {
            int cur = i*i+n;
            int sqrt = (int) Math.sqrt(cur);
            if (sqrt > 500) break;
            if (sqrt*sqrt == cur)
                cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
