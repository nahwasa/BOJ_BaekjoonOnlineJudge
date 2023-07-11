import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String s = br.readLine();
            char bf = ' ';
            StringBuilder tmp = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == bf) continue;

                bf = s.charAt(i);
                tmp.append(bf);
            }
            sb.append(tmp).append('\n');
        }

        System.out.print(sb);
    }
}
