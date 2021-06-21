import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r+1][c+1];
        int max = 0;
        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 1; j <= c; j++) {
                if (row.charAt(j-1) != '1')   continue;
                int min = Math.min(map[i-1][j], map[i][j-1]);
                min = Math.min(min, map[i-1][j-1]);
                map[i][j] = min + 1;
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max*max);
    }
}
