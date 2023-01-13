import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
            new Main().solution();
        System.out.print(sb);
    }

    private int palindrome(String str, int s, int e, int chk) {
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
                continue;
            }
            if (chk != 0)
                return 2;
            chk++;
            int res = palindrome(str, s, e-1, chk);
            if (res == 1) {
                e--;
                continue;
            }
            res = palindrome(str, s+1, e, chk);
            if (res == 1) {
                s++;
                continue;
            }
        }
        return chk;
    }

    public void solution() throws Exception {
        String str = br.readLine();
        sb.append(palindrome(str, 0, str.length()-1, 0)).append('\n');
    }
}
