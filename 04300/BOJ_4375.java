import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder answer = new StringBuilder();
        while ((s=br.readLine()) != null) {
            BigInteger n = new BigInteger(s);
            BigInteger base = BigInteger.ZERO;
            while(true) {
                base = base.multiply(BigInteger.TEN).add(BigInteger.ONE);
                if (base.mod(n).equals(BigInteger.ZERO)) {
                    answer.append(base.toString().length()).append('\n');
                    break;
                }
            }
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
