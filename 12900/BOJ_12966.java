import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        int sqrt = (int) Math.sqrt(x+y);
        if (1l*sqrt*sqrt != x+y) {
            System.out.println(-1);
            return;
        }
        if (x == 2 || y == 2) {
            System.out.println(-1);
            return;
        }

        if (x == 0) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for (int i = sqrt; i >= 2; i--) {
            long score = 2*i-1;
            if (x >= score) {
                x -= score;
                cnt++;
            }
            if (x <= 2)
                break;
        }

        System.out.println(cnt+=x);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
