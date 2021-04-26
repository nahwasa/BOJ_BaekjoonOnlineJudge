import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] arr;
    static int wCnt, bCnt, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) arr[i][j] = st.nextToken().charAt(0) == '0' ? true : false;
        }
        solve(0, 0, n);
        System.out.println(String.format("%d\n%d", wCnt, bCnt));
    }

    private static void solve(int c, int r, int s) {
        int cnt = 0;
        if (s == 1) {
            s = 1;
        }
        for (int i = c; i < c+s; i++) for (int j = r; j < r+s; j++) cnt+=arr[i][j]?0:1;
        if (cnt == s*s) {
            bCnt++;
            return;
        }
        if (cnt == 0) {
            wCnt++;
            return;
        }
        int tmp = s/2;
        solve(c, r, tmp);
        solve(c, r+tmp, tmp);
        solve(c+tmp, r, tmp);
        solve(c+tmp, r+tmp, tmp);
    }
}
