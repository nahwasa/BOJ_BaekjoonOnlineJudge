import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            boolean answer = arr[2]*arr[2]==arr[0]*arr[0]+arr[1]*arr[1];
            sb.append(String.format("Case #%d: %s\n", tc, answer?"YES":"NO"));
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
