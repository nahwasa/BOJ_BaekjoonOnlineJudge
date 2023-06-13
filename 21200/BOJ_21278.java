import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 100007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = initMap(n, m);

        floydWarshall(n, map);

        System.out.println(answer(n, map));
    }

    private int[][] initMap(final int n, int m) throws IOException {
        int[][] map = new int[n][n];
        for (int[] row : map)
            Arrays.fill(row, INF);

        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = map[b][a] = 1;
        }

        return map;
    }

    private void floydWarshall(final int n, int[][] map) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    map[i][j] = map[j][i] = min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    private String answer(final int n, final int[][] map) {
        int min = INF;
        int ansA = 0;
        int ansB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) continue;

                    sum += min(map[i][k], map[j][k]);
                }

                if (min > sum) {
                    min = sum;
                    ansA = i;
                    ansB = j;
                }

            }
        }

        return String.format("%d %d %d", ansA+1, ansB+1, min*2);
    }
}
