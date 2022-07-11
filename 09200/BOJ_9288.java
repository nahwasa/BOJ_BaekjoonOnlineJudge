import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(br.readLine());
            sb.append(String.format("Case %d:\n", i));
            for (int a = 1; a <= 6; a++) {
                for (int b = a; b <= 6; b++) {
                    if (a+b == cur) {
                        sb.append(String.format("(%d,%d)\n", a, b));
                    }
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
