import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        int cnt = 0;
        boolean chk = false;
        for (int i = s.length()-1; i >= 0; i--) {
            if (!chk && s.charAt(i) == '0') continue;

            chk = true;
            if (s.charAt(i) == '0') cnt++;
        }

        System.out.println(cnt);
    }
}
