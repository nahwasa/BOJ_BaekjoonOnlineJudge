import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int N = Integer.parseInt(n);
        String m = st.nextToken();
        int M = Integer.parseInt(m);
        BigInteger nPm = new BigInteger(n);
        for (int i = N-1, cnt = M; --cnt>0; i--) {
            nPm = nPm.multiply(new BigInteger(String.valueOf(i)));
        }
        BigInteger factM = new BigInteger(m);
        for (int i = M-1; i > 0; i--) {
            factM = factM.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(nPm.divide(factM));
    }
}
