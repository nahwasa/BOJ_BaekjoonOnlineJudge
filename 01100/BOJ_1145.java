import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int max = arr[0] * arr[1] * arr[2];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            int base = arr[i];
            for (; base <= max; base+=arr[i]) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) if (base % arr[k] == 0) cnt++;
                if (cnt >= 3) answer = Math.min(answer, base);
            }
        }
        System.out.println(answer);
    }
}
