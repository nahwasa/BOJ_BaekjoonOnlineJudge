import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int s = 0, e = n-1;
            int minGap = Integer.MAX_VALUE;
            int answer = 0;
            while (s<e) {
                int sum = arr[s] + arr[e];
                int gap = Math.abs(sum-k);
                if (minGap >= gap) {
                    if (minGap > gap) answer = 0;
                    minGap = gap;
                    answer++;
                }

                if (sum >= k)
                    e--;
                else
                    s++;
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
