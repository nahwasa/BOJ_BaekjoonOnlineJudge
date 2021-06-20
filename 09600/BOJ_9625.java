import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][k+1];
        arr[0][0] = 1;
        arr[1][0] = 0;
        for (int i = 1; i <= k; i++) {
            arr[0][i] = arr[1][i-1];
            arr[1][i] = arr[0][i-1] + arr[1][i-1];
        }
        System.out.println(String.format("%d %d", arr[0][k], arr[1][k]));
    }
}
