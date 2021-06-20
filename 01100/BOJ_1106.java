import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[c + 101];
        Arrays.fill(arr, 110001);
        arr[0] = 0;
        int n = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                int curNum = num[j];
                if (i-curNum < 0) continue;
                arr[i] = Math.min(arr[i], arr[i-curNum] + cost[j]);
            }
        }

        int min = arr[c];
        for (int i = c+1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        System.out.println(min);
    }
}
