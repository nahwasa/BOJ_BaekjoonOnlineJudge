import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (a<=b) {
            sb.append(isPalindrome(a) ? "Palindrome!" : a);
            sb.append('\n');
            a++;
        }
        System.out.print(sb);
    }

    private boolean isPalindrome(long n) {
        String s = String.valueOf(n);
        int len = s.length();
        for (int i = 0; i < len/2; i++)
            if (s.charAt(i) != s.charAt(len-1-i))
                return false;
        return true;
    }
}
