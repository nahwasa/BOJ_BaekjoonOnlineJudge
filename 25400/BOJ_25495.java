import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int bf = 0;
        int cnt = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur != bf) {
                cnt = 1;
                bf = cur;
            }
            cnt*=2;
            sum += cnt;
            if (sum >= 100) {
                sum = 0;
                cnt = 1;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
