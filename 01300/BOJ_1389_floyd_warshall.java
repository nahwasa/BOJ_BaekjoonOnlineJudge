import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for (int[] i : arr) Arrays.fill(i, 1000);
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        for (int k = 1; k <= n; k++) for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
        int min = Integer.MAX_VALUE;
        int minNum = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j <= n; j++) {
                if (i==j) continue;
                cnt+=arr[i][j];
            }
            if (min > cnt) {
                min = cnt;
                minNum = i;
            }
        }
        System.out.println(minNum);
    }
}
class Pos {
    int n, d;
    public Pos (int n, int d) {this.n=n; this.d=d;}
}
