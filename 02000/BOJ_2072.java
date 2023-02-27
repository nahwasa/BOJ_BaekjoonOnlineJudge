import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int[][] arr = new int[20][20];
        int n = Integer.parseInt(br.readLine());
        if (n < 9) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = i%2 + 1;
        }

        for (int i = 8; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = i%2 + 1;
            if (is5mok(arr, a, b, i%2 + 1)) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(-1);
    }

    private static final int[] DR = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int[] DC = {1, -1, 0, 0, -1, 1, 1, -1};
    private boolean is5mok(int[][] arr, int r, int c, int color) {
        int[] cnt = new int[4];
        Arrays.fill(cnt, 1);
        for (int d = 0; d < 8; d++) {
            for (int a = r+DR[d], b = c+DC[d]; a>=0 && a<arr.length && b>=0 && b<arr[0].length && arr[a][b] == color; a+=DR[d], b+=DC[d]) {
                cnt[d/2]++;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (cnt[i] == 5)
                return true;
        }
        return false;
    }
}
