import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 2; i <= n; i++) {
                int cnt = 0;
                while (n%i==0) {
                    n/=i;
                    cnt++;
                }
                if (cnt != 0)
                    sb.append(i).append(' ').append(cnt).append('\n');
                if (n == 0)
                    break;
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
