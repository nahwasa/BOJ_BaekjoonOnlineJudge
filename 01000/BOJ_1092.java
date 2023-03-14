import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int[] cnt = new int[n];
        int k = Integer.parseInt(br.readLine());
        int limit = k/n + (k%n!=0 ? 1 : 0);
        st = new StringTokenizer(br.readLine());
        while (k-->0) {
            int cur = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                if (arr[i] >= cur) {
                    cnt[i]++;
                    break;
                }
                if (i == n-1) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        while (true) {
            int tmp = cnt[0];
            for (int i = 0; i < n-1; i++) {
                if (tmp <= limit) {
                    tmp = cnt[i+1];
                    continue;
                }
                int gap = tmp - limit;
                tmp = cnt[i+1] + gap;
            }
            if (tmp <= limit) {
                System.out.println(limit);
                return;
            }
            limit++;
        }
    }
}
