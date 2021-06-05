import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long div = 2;
        long res = n;
        long limit = (long) Math.sqrt(n);

        while (n != 1 && div <= limit) {
            if (n%div == 0) {
                while (n % div == 0) n /= div;
                res -= res / div;
            }
            div++;
        }
        if (n != 1) res -= res/n;

        System.out.println(res);
    }
}
