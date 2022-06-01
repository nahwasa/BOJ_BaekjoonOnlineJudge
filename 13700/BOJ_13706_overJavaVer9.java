import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger(br.readLine());
        System.out.println(bi.sqrt());
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
