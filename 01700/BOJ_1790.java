import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sum = 0;
        int base = 1;
        for (int i = 1; i <= 8; i++, base*=10) {
            int cnt = base*9;
            if (sum + cnt*i < k) {
                sum += cnt*i;
                continue;
            }

            int num = base + (k-sum-1)/i;
            if (num > n) System.out.println(-1);
            else System.out.println(String.valueOf(num).charAt((k-sum-1)%i));
            return;
        }

        System.out.println(k-sum<=9 ? (k-sum==0?1:0) : -1);
    }
}
