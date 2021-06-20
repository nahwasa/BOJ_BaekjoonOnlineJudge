import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int[] tmp = {
                    i % 3 == 0 ? arr[i / 3]+1 : Integer.MAX_VALUE,
                    i % 2 == 0 ? arr[i / 2]+1 : Integer.MAX_VALUE,
                    arr[i-1]+1
            };
            Arrays.sort(tmp);
            arr[i] = tmp[0];
        }
        System.out.println(arr[n]);
    }
}
