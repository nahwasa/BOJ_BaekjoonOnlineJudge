import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            cur += arr[4] + arr[3];
            
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
