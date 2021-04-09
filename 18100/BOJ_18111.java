import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = 257;
        int minTime = Integer.MAX_VALUE;
        int minHeight = 0;
        while (k-->0) {
            int timeSum = 0;
            int remain = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int gap = k - arr[i][j];
                    if (gap >= 0) {
                        timeSum += gap;
                        remain -= gap;
                    } else {
                        timeSum -= 2*gap;
                        remain -= gap;
                    }
                }
            }
            if (remain >= 0 && timeSum < minTime) {
                minTime = timeSum;
                minHeight = k;
            }
        }
        System.out.println(String.format("%d %d", minTime, minHeight));
    }
}
