import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] arr = new int[l+1];
        arr[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= l; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());
        int i = 0;
        while (i++ <= l)  if (arr[i-1] <= n && arr[i] >= n)   break;
        System.out.println( Math.max(0, (n - arr[i-1]) * (arr[i] - n) - 1) );
    }
}
