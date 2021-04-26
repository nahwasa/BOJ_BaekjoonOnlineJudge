import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) arr[i][j] = s.charAt(j)=='1' ? true : false;
        }
        solve(0, 0, n);
        System.out.println(sb);
    }

    private static void solve(int r, int c, int size) {
        int cnt = 0;
        for (int i = r; i < r+size; i++) for (int j = c; j < c+size; j++) cnt += arr[i][j]?1:0;
        if (cnt == size*size) {
            sb.append('1');
            return;
        } else if (cnt == 0) {
            sb.append('0');
            return;
        }
        sb.append('(');
        int next = size/2;
        solve(r, c, next);
        solve(r, c+next, next);
        solve(r+next, c, next);
        solve(r+next, c+next, next);
        sb.append(')');
    }
}
