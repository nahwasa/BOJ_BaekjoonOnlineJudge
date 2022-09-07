import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int LIMIT = 30;
    private int[][] getPascalTriangle() {
        int[][] arr = new int[LIMIT+1][];
        for (int i = 1; i <= LIMIT; i++) {
            arr[i] = new int[i+1];
        }
        arr[1][1] = 1;
        for (int i = 1; i < LIMIT; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i+1][j] += arr[i][j];
                arr[i+1][j+1] += arr[i][j];
            }
        }
        return arr;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = getPascalTriangle();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = r, k = 0; k < w; i++, k++) {
            for (int j = c; j <= c+k; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
