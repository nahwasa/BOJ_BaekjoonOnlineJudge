import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private boolean isPalindrome(int len, int num) {
        String tmp = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len-tmp.length(); i++) {
            sb.append('0');
        }
        sb.append(tmp);
        tmp = sb.toString();

        int st = 0, ed = len-1;
        for (int i = 0; i < len/2; i++) {
            if (tmp.charAt(st+i) != tmp.charAt(ed-i))
                return false;
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.length()<2) break;
            int len = s.length();
            int num = Integer.parseInt(s);
            int cnt = 0;
            while (!isPalindrome(len, num+cnt++)) {}
            sb.append(cnt-1).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
