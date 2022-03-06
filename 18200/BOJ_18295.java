import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] chk = new boolean[1000002];
        while (n-->0) {
            String cur = br.readLine();
            if (cur.charAt(0)=='-' || cur.length()>6 && !cur.equals("1000000")) continue;
            chk[Integer.parseInt(cur)] = true;
        }
        for (int i = 0; i <= 1000001; i++) {
            if (!chk[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
