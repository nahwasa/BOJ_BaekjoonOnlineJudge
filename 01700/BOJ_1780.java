import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] resCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        resCnt = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0, n);
        System.out.println(String.format("%d\n%d\n%d", resCnt[0], resCnt[1], resCnt[2]));
    }

    private static void solve(int c, int r, int size) {
        int base = arr[c][r];
        for (int i = c; i < c+size; i++) for (int j = r; j < r+size; j++) {
            if (base != arr[i][j]) {
                base = -2;
                break;
            }
        }
        if (base != -2) {
            resCnt[base+1]++;
            return;
        }
        int ns = size/3;
        int[] next = new int[3];
        next[1] = ns;
        next[2] = ns*2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(c+next[i], r+next[j], ns);
            }
        }

    }
}
