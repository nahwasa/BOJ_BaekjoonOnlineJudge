import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j)=='#'?false:true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (c-j >= n) {
                    int k = 0;
                    while (k<n) {
                        if (!arr[i][j+k]) break;
                        k++;
                    }
                    if (k==n) cnt++;
                }

                if (r-i >= n) {
                    int k = 0;
                    while (k<n) {
                        if (!arr[i+k][j]) break;
                        k++;
                    }
                    if (k==n) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
