import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());
        b = b.subtract(c);
        b = b.divide(a);
        System.out.println(b);
    }
 
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
