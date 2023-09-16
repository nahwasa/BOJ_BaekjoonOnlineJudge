import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(br.readLine());
            sb.append("Case #").append(i).append(':').append(' ');

            if (cur <= 25) sb.append("World Finals");
            else if (cur <= 1000) sb.append("Round 3");
            else if (cur <= 4500) sb.append("Round 2");
            else sb.append("Round 1");

            sb.append('\n');
        }
        System.out.print(sb);
    }
}
