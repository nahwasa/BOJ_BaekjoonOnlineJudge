import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int tripleMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0)
                break;

            int[][] arr = new int[r+1][c+1];
            int max = 0;
            for (int i = 1; i <= r; i++) {
                String s = br.readLine();
                for (int j = 1; j <= c; j++) {
                    int cur = s.charAt((j - 1) * 2) - '0';
                    if (cur == 0) continue;
                    arr[i][j] = tripleMin(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]) + 1;
                    max = Math.max(max, arr[i][j]);
                }
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}
