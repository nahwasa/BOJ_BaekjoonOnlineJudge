import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][10];
        Arrays.fill(arr[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] += arr[i - 1][j] + (j==0?0 : arr[i][j-1]);
                arr[i][j] %= 10007;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += arr[n-1][i];
        System.out.println(sum % 10007);
    }
}
