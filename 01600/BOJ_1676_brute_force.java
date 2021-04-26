import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger("1");
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println("0");
            return;
        }
        for (int i = 1; i <= n; i++) {
            bi = bi.multiply(new BigInteger(String.valueOf(i)));
        }
        String res = bi.toString();
        int cnt = 0;
        for (int i = res.length()-1; i >= 0; i--) {
            if (res.charAt(i) != '0')   break;
            cnt++;
        }
        System.out.println(cnt);
    }
}
