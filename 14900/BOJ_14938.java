import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int INF = 100*30+1;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) item[i] = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n+1][n+1];
        for (int[] row : dist) Arrays.fill(row, INF);
        while (r-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = len;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = item[i];

            for (int j = 1; j <= n; j++) {
                if (i==j || dist[i][j] > m) continue;

                sum += item[j];
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
