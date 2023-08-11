import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int INVALID = -1;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sNum = Long.parseLong(st.nextToken());
        long xNum = Long.parseLong(st.nextToken());
        String s = Long.toBinaryString(sNum);
        String x = Long.toBinaryString(xNum);

        if (s.length() == x.length()) {
            s = lpad(s, 1);
            x = lpad(x, 1);
        } else if (s.length() > x.length()) {
            s = lpad(s, 1);
            x = lpad(x, s.length()-x.length());
        } else {
            x = lpad(x, 1);
            s = lpad(s, x.length()-s.length());
        }

        int len = s.length();
        int c = 0;
        int cnt = 0;
        for (int i = len-1; i >= 0; i--) {
            int xBit = x.charAt(i)-'0';
            int sBit = s.charAt(i)-'0';

            if (i==0 && c==1) {
                System.out.println(0);
                return;
            }

            c = chk(xBit, sBit, c);
            if (c == INVALID) {
                System.out.println(0);
                return;
            }

            if (xBit == 1) cnt++;
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        long ans = 1;
        while (cnt-->0) ans*=2;

        if (sNum==xNum) ans-=2;

        System.out.println(ans);
    }

    private int chk(final int x, final int s, final int c) {
        if (x==0 && s==0) return c==1?-1:2;
        if (x==1 && s==0) return c==0?-1:1;
        if (x==1 && s==1) return c==1?-1:0;
        return c==0?-1:2;
    }

    private String lpad(String str, int gap) {
        StringBuilder sb = new StringBuilder();
        while (gap-->0) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }
}
