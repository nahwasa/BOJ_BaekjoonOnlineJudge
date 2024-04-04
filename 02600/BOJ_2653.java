import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = st.nextToken().charAt(0) == '0';
            }
        }

        boolean[] v = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        int groupCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (v[i]) continue;
            v[i] = true;

            groupCnt++;
            int cnt = 1;
            sb.append(i).append(' ');
            for (int j = 1; j <= n; j++) {
                if (i == j || !arr[i][j]) continue;
                if (v[j]) {
                    end();
                    return;
                }
                v[j] = true;
                cnt++;
                sb.append(j).append(' ');
            }

            if (cnt == 1) {
                end();
                return;
            }

            sb.append('\n');
        }
        System.out.println(groupCnt);
        System.out.print(sb);
    }

    private void end() {
        System.out.println(0);
    }
}
