import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine().split(" ")[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[2][w];
        Arrays.fill(arr[1], 500);
        for (int i = 0; i < w; i++) arr[0][i]=Integer.parseInt(st.nextToken());
        int lmax = 0, rmax = 0;
        for (int l = 0, r = w-1; l < w; l++, r--) {
            arr[1][l] = Math.min(arr[1][l], (lmax = Math.max(lmax, arr[0][l])));
            arr[1][r] = Math.min(arr[1][r], (rmax = Math.max(rmax, arr[0][r])));
        }
        int sum = 0;
        for (int i = 0; i < w; i++) sum += arr[1][i]-arr[0][i];
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
