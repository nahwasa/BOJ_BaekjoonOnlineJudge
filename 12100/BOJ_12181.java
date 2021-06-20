import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long[][] arr = new long[r][c+1];
            Arrays.fill(arr[r-1], 1);
            for (int i = r-2; i >= 0; i--) {
                for (int j = c-1; j >= 0; j--) {
                    arr[i][j] = arr[i][j+1] + arr[i+1][j];
                }
            }
            sb.append("Case #").append(t).append(": ").append(arr[0][0]).append('\n');
        }
        System.out.println(sb);
    }
}
