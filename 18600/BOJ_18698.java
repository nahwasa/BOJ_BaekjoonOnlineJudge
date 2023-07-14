import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            String s = br.readLine();
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'D') break;
                cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
