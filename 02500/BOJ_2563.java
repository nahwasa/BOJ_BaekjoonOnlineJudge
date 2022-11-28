import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        int ans = 0;
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int i = r; i < r+10; i++) {
                for (int j = c; j < c+10; j++) {
                    if (++arr[i][j] == 1)
                        ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
