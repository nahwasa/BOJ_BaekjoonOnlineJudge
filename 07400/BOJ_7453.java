import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static int lower(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int m = (l + h) >>> 1;
            int mVal = arr[m];
            if (mVal < key)
                l = m + 1;
            else
                h = m - 1;
        }
        return h;
    }

    private static int upper(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int m = (l + h) >>> 1;
            int mVal = arr[m];
            if (mVal <= key)
                l = m + 1;
            else
                h = m - 1;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)     arr[j][i] = Integer.parseInt(st.nextToken());
        }
        int[] ab = new int[n*n];
        for (int i = 0, k = -1; i < n; i++)
            for (int j = 0; j < n; j++)
                ab[++k] = arr[0][i] + arr[1][j];
        Arrays.sort(ab);
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = arr[2][i] + arr[3][j];
                if (Arrays.binarySearch(ab, -tmp) >= 0)
                    cnt = cnt + upper(ab, -tmp) - lower(ab, -tmp) - 1;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
