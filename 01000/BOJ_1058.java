import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (arr[i][j] || s.charAt(j) == 'N') continue;
                arr[i][j] = arr[j][i] = true;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i][j]) {
                    cnt++;
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k==i || k==j)   continue;
                    if (arr[i][k] && arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
