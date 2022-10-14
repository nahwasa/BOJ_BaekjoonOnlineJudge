import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    int[][] arr;
    int k;

    private void fill(int r, int c) {
        for (int i = r*k; i < r*k+k; i++) {
            for (int j = c*k; j < c*k+k; j++) {
                arr[i][j] = 1;
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n*k][n*k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().charAt(0) == '1')
                    fill(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr[0].length; j++) {
                 sb.append(arr[i][j]).append(' ');
             }
             sb.append('\n');
         }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
