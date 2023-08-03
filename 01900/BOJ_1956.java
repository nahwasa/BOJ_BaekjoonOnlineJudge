import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int INF = 4000001;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v+1][v+1];
        for (int[] row : arr) Arrays.fill(row, INF);
        while (e-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {

                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);

                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer, arr[i][i]);
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}
