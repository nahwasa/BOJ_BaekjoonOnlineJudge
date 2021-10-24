import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = input.length();

        boolean isReverse = false;
        int[] arr = new int[cnt+1];
        int[][] dp = new int[2][cnt+1];
        int numCnt = 0;

        int idx = 0;
        for (int i = 0; i < cnt; i++) {
            char c = input.charAt(i);
            if (c == '-') {
                isReverse = !isReverse;
                continue;
            }
            numCnt++;
            arr[idx] = c-'0';
            dp[isReverse?1:0][idx] = 1;
            idx++;
        }

        int chk = 2;
        for (int i = numCnt-1; i >= 0; i--) {
            boolean state = chk != dp[0][i];
            if (state) {
                chk = dp[0][i];
                dp[1][i] = dp[0][i+1]+1;
                dp[0][i] = dp[1][i+1];
            } else {
                dp[0][i] = dp[0][i+1];
                dp[1][i] = dp[1][i+1]+1;
            }
        }

        int[] answer = new int[cnt+2];
        for (int i = 0; i < numCnt; i++) {
            int dp1 = dp[1][i];
            int dp0 = dp[0][i];
            int num = arr[i];

            if (dp1 != 0) {
                answer[answer.length-1-dp1] += num;
                answer[answer.length-1] -= num;
            }

            if (dp0 != 0) {
                answer[answer.length-1-dp0-i-1] += num;
                answer[answer.length-1-i-1] -= num;
            }
        }

        for (int i = answer.length-1; i >= 1; i--) {
            if (answer[i] < 0) {
                int div = answer[i] / 10;
                int mod = answer[i] % 10;
                if (mod != 0) div--;
                answer[i-1] += div;
                answer[i] += -div*10;
            } else if (answer[i] >= 10) {
                answer[i-1] += answer[i] / 10;
                answer[i] %= 10;
            }
        }

        int base = 0;
        for (int i = 0; i < answer.length; i++) {
            base *= 10;
            base += answer[i];
            if (base < 9) {
                answer[i] = 0;
                continue;
            }
            answer[i] = base / 9;
            base %= 9;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < answer.length; i++) {
            if (answer[i] != 0) break;
        }
        for (; i < answer.length; i++) {
            sb.append(answer[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
