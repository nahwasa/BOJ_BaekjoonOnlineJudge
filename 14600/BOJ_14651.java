import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000_009;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n==1) {
            System.out.println(0);
            return;
        }
        int answer = 2;
        for (int i = 2; i < n; i++) {
            answer = (int) (1l*answer*3%MOD);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
