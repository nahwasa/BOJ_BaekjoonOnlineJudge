import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger(br.readLine());
        if (bi.equals(new BigInteger("0"))) System.out.println(0);

        final BigInteger two = new BigInteger("2");
        final BigInteger zero = new BigInteger("0");

        for (int i = 64; i > 0; i--) {
            if (!bi.mod(two).equals(zero)) {
                System.out.println(i);
                return;
            }
            bi = bi.divide(two);
        }
    }
}
