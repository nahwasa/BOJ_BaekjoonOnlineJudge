import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String cur = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = cur.charAt(j);
            }
        }

        String word = br.readLine();
        long[][][] dp = new long[r][c][len];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == word.charAt(0))
                    dp[i][j][0] = 1;
            }
        }

        long answer = 0;
        for (int k = 1; k < len; k++) {
            char cur = word.charAt(k);
            char bf = word.charAt(k-1);

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] != cur) continue;

                    for (int dr = -1; dr <= 1; dr++) {
                        for (int dc = -1; dc <= 1; dc++) {
                            if (dr==0 && dc==0) continue;
                            int nr = i+dr;
                            int nc = j+dc;
                            if (nr<0||nr>=r||nc<0||nc>=c||arr[nr][nc]!=bf) continue;

                            dp[i][j][k] += dp[nr][nc][k-1];
                        }
                    }

                    if (k == len-1) answer += dp[i][j][k];
                }
            }
        }

        System.out.println(answer);
    }
}
