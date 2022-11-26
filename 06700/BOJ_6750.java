import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String TARGET_LETTERS = "IOSHZXN";
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            boolean chk = false;
            for (int j = 0; j < TARGET_LETTERS.length(); j++) {
                if (TARGET_LETTERS.charAt(j) == s.charAt(i)) {
                    chk = true;
                    break;
                }
            }
            if (!chk) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
