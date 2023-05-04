import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int[] dp = getDp();

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;


            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }

    private int[] getDp() {
        int[][] dp = new int[301][18];
        int[] result = new int[301];
        dp[0][0] = 1;

        for (int i = 1; i <= 300; i++) {
            for (int c = 1; c <= 17; c++) {
                int square = c*c;
                if (i - square < 0) break;

                for (int j = 0; j <= c; j++) {
                    dp[i][c] += dp[i-square][j];
                }
            }

            for (int j = 1; j <= 17; j++) {
                result[i] += dp[i][j];
            }
        }

        return result;
    }
}
