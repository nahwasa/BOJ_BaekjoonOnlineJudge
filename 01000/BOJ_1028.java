import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // input & init
        boolean[][] input = new boolean[r+2][c+2];
        for (int i = 1; i <= r; i++) {
            String s = br.readLine();
            for (int j = 1; j <= c; j++) input[i][j] = s.charAt(j-1) == '1' ? true : false;
        }
        int[][][] arr = new int[r+2][c+2][2];
        for (int i = r; i > 0; i--) {
            for (int j = 1; j <= c; j++) {
                if (!input[i][j]) continue;
                arr[i][j][0] = arr[i+1][j-1][0] + 1;
                arr[i][j][1] = arr[i+1][j+1][1] + 1;
            }
        }
        // process
        int res = 0;
        for (int i = 1; i <= r - res; i++) {
            for (int j = 1; j <= c - res; j++) {
                int base = Math.min(arr[i][j][0], arr[i][j][1]);
                for (int k = base; k >= res; k--) {
                    if (arr[i+k-1][j-k+1][1] >= k && arr[i+k-1][j+k-1][0] >= k) {
                        res = Math.max(res, k);
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
