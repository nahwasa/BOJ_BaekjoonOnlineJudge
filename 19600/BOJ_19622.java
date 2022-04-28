import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][2];
        for (int i = 2; i <= n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); st.nextToken();
            int cur = Integer.parseInt(st.nextToken());
            arr[i][0] = Math.max(arr[i-1][0], arr[i-1][1]);
            arr[i][1] = Math.max(arr[i-1][0], arr[i-2][1]) + cur;
        }
        System.out.print(Math.max(arr[n+1][0], arr[n+1][1]));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
