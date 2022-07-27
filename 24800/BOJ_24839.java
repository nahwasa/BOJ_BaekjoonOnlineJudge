import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            String from = br.readLine();
            String to = br.readLine();
            int pt = 0;
            boolean chk = false;
            for (int i = 0; i < from.length(); i++) {
                chk = false;
                while (pt < to.length()) {
                    if (to.charAt(pt++) == from.charAt(i)) {
                        chk = true;
                        break;
                    }
                }
                if (!chk) break;
            }
            sb.append(String.format("Case #%d: ", t)).append(!chk?"IMPOSSIBLE":to.length()-from.length()).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
