import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private BigInteger sqrt(BigInteger bi) {
        BigInteger div = BigInteger.ZERO.setBit(bi.bitLength()/2);
        BigInteger div2 = div;
        while(true) {
            BigInteger tmp = div.add(bi.divide(div)).shiftRight(1);
            if (tmp.equals(div) || tmp.equals(div2))
                return tmp;
            div2 = div;
            div = tmp;
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger(br.readLine());
        System.out.println(sqrt(bi));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
