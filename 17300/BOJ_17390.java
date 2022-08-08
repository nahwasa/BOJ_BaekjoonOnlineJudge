import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int getRangedSum(int[] arr, int l, int r) {
        return arr[r] - arr[l-1];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i-1];
        }

        StringBuilder answer = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            answer.append(getRangedSum(arr, l, r)).append('\n');
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
