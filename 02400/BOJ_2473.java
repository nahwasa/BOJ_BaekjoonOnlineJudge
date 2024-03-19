import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int[] ans = new int[3];

        for (int base = 0; base < n; base++) {
            int s = 0;
            int e = n-1;

            while (s<e) {
                if (s == base) {s++; continue;}
                if (e == base) {e--; continue;}

                long sum = 0l + arr[base] + arr[s] + arr[e];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    ans = new int[] {arr[base], arr[s], arr[e]};
                }

                if (sum == 0) {printAns(ans); return;}
                if (sum < 0) {s++; continue;}
                e--;
            }
        }

        printAns(ans);
    }

    private void printAns(int[] ans) {
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
