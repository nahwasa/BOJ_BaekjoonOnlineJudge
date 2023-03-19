import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine().toLowerCase();
            if (s.equals("#")) break;
            char c = s.charAt(0);
            int cnt = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == c)
                    cnt++;
            }

            sb.append(c).append(' ').append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
