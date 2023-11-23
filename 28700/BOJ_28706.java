import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n+1];
            dp[0] = 1<<1;

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int op1 = st.nextToken().charAt(0) == '+' ? 0 : 1;
                int num1 = Integer.parseInt(st.nextToken());
                int op2 = st.nextToken().charAt(0) == '+' ? 0 : 1;
                int num2 = Integer.parseInt(st.nextToken());

                dp[i] = proc(dp[i-1], op1, num1, op2, num2);
            }

            sb.append((dp[n]&1)==1 ? "LUCKY" : "UNLUCKY").append('\n');
        }
        System.out.print(sb);
    }

    private int proc(final int bf, final int op1, final int num1, final int op2, final int num2) {
        int result = 0;
        for (int i = 0; i <= 6; i++) {
            if ((bf&(1<<i)) == 0) continue;

            int tmp = i;
            if (op1 == 0) tmp+=num1;
            else tmp*=num1;
            result |= 1<<(tmp%7);

            tmp = i;
            if (op2 == 0) tmp+=num2;
            else tmp*=num2;
            result |= 1<<(tmp%7);
        }
        return result;
    }
}
