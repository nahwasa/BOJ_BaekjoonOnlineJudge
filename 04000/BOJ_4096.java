import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int len, baseLow, baseHigh;

    private boolean isPalindrome(int num) {
        int low = baseLow;
        int high = baseHigh;
        for (int i = 0; i < len/2; i++, low*=10, high/=10)
            if ((num%low)/(low/10) != (num/high)%10) return false;
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        do {
            len = s.length();
            baseLow = 10;
            baseHigh = 1;
            for (int i = 0; i < len-1; i++) baseHigh*=10;
            int num = Integer.parseInt(s);
            int cnt = -1;
            while (!isPalindrome(++cnt+num)) {}
            sb.append(cnt).append('\n');
            s = br.readLine();
        } while (s.length()>1);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
