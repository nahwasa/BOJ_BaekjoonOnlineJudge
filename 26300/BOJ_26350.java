import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            String s = br.readLine();
            sb.append("Denominations: " + s.substring(s.indexOf(' ')+1)).append('\n');
            StringTokenizer st = new StringTokenizer(s);
            sb.append(chk(st) ? "Good coin denominations!\n\n" : "Bad coin denominations!\n\n");
        }

        System.out.print(sb);
    }

    private boolean chk(StringTokenizer st) {
        int n = Integer.parseInt(st.nextToken());

        int base = Integer.parseInt(st.nextToken());
        while (--n>0) {
            int cur = Integer.parseInt(st.nextToken());
            if (base * 2 > cur) return false;
            base = cur;
        }
        return true;
    }
}
