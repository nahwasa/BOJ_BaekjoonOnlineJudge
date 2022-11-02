import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;
        for (int i = 1; i <= k; i++) {
            int base = n*i;
            String baseStr = String.valueOf(base);
            int reverse = Integer.parseInt(new StringBuilder(baseStr).reverse().toString());
            max = Math.max(max, reverse);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
