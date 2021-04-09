import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            BigInteger tmp = new BigInteger(charToIdx(s.charAt(i)));
            tmp = tmp.multiply(new BigInteger("31").pow(i));
            sum = sum.add(tmp);
        }
        System.out.println(sum.mod(new BigInteger("1234567891")).toString());
    }

    private static String charToIdx(char c) {
        return "" + (c-'a'+1);
    }
}
