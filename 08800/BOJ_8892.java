import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private boolean isPalindrome(String a, String b) {
        String cur = a + b;
        boolean isPalindrome = true;
        for (int k = 0; k < cur.length()/2; k++) {
            if (cur.charAt(k) != cur.charAt(cur.length()-1-k)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            boolean chk = true;
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = br.readLine();
            for (int i = 0; i < n-1 && chk; i++) {
                for (int j = i+1; j < n && chk; j++) {
                    if (i == j) break;
                    if (isPalindrome(arr[i], arr[j])) {
                        chk = false;
                        sb.append(arr[i]+arr[j]).append('\n');
                        break;
                    }
                    if (isPalindrome(arr[j], arr[i])) {
                        chk = false;
                        sb.append(arr[j]+arr[i]).append('\n');
                        break;
                    }
                }
            }
            if (chk) sb.append(0).append('\n');

        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
