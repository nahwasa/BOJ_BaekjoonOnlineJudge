import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> hs = new HashSet<>();
            int cur = n;
            for (int i = 1; i <= 100; i++, cur+=n) {
                int tmp = cur;
                while (tmp != 0) {
                    hs.add(tmp%10);
                    tmp/=10;
                }
                if (hs.size() == 10)
                    break;
            }
            sb.append(String.format("Case #%d: ", tc)).append(hs.size()!=10?"INSOMNIA":cur).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
