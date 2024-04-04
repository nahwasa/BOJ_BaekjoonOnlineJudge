import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (v[i]) continue;
            v[i] = true;

            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            for (int j = 1; j <= n; j++) {
                if (i == j || !arr[i][j]) continue;
                if (v[j]) {
                    end();
                    return;
                }
                v[j] = true;
                tmp.add(j);
            }

            if (tmp.size() == 1) {
                end();
                return;
            }

            for (int cur1 : tmp) {
                for (int cur2 : tmp) {
                    if (!arr[cur1][cur2]) {
                        end();
                        return;
                    }
                }
            }

            cnt++;
            for (int cur : tmp) {
                sb.append(cur).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(cnt);
        System.out.print(sb);
    }

    private void end() {
        System.out.println(0);
    }
}
