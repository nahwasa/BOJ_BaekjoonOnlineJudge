import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private boolean isPalindrome(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            sb.append(isPalindrome(br.readLine()) ? "Yes\n" : "No\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
