import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int s = 0, e = n-1;
        int min = Integer.MAX_VALUE;
        int ansS = 0, ansE = 0;
        while (s < e) {
            int sum = Math.abs(arr[e]+arr[s]);
            if (sum < min) {
                min = sum;
                ansS = s;
                ansE = e;
            }
            if (sum == 0)
                break;

            if (arr[e]+arr[s] > 0) e--;
            else s++;
        }

        System.out.println(arr[ansS] + " " + arr[ansE]);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
