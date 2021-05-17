import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        int chk = arr[1]-arr[0];
        boolean isSum = true;
        for (int i = 2; i < n; i++) {
            if (arr[i]-arr[i-1] == chk) continue;
            isSum = false;
            break;
        }
        System.out.println(isSum ? arr[n-1]+chk : arr[n-1] * (arr[n-1]/arr[n-2]));
    }
}
