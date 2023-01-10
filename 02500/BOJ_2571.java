import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int SQUARE_LENGTH = 100;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[SQUARE_LENGTH+1][SQUARE_LENGTH+1];
        for (int[] row : arr)
            Arrays.fill(row, -10001);
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int i = r; i < r+10; i++) {
                for (int j = c; j < c+10; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int[][] prefixSum = new int[SQUARE_LENGTH+1][SQUARE_LENGTH+1];
        for (int i = 1; i <= SQUARE_LENGTH; i++) {
            for (int j = 1; j <= SQUARE_LENGTH; j++) {
                prefixSum[i][j] = arr[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        int answer = 0;
        for (int i = 1; i <= SQUARE_LENGTH; i++) {
            for (int j = 1; j <= SQUARE_LENGTH; j++) {
                for (int ib = i+1; ib <= SQUARE_LENGTH; ib++) {
                    for (int jb = j+1; jb <= SQUARE_LENGTH; jb++) {
                        int area = prefixSum[ib][jb] - prefixSum[i-1][jb] - prefixSum[ib][j-1] + prefixSum[i-1][j-1];
                        if (area < 0) break;
                        answer = Math.max(area, answer);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
