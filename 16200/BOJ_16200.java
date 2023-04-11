import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int cnt = 0;
        int limit = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if (cnt == 0) limit = cur;
            cnt++;

            if (cnt == limit) {
                cnt = 0;
                answer++;
            }
        }
        if (cnt != 0) answer++;

        System.out.println(answer);
    }
}
