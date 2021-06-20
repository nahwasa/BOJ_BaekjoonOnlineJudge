import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] hp = new int[n];
        int[] happy = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) hp[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) happy[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[100];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            int curHp = hp[i];
            int curHappy = happy[i];

            for (int j = 100-curHp-1; j >= 0; j--) {
                if (arr[j] == -1)    continue;
                arr[j+curHp] = Math.max(arr[j+curHp], arr[j] + curHappy);
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ans < arr[i])   ans = arr[i];
        }
        System.out.println(ans);
    }
}
