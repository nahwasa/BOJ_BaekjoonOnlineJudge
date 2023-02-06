import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = -1;
        while ( (n = Long.parseLong(br.readLine())) != 0 ) {
            if (n == 1) {
                sb.append(0).append('\n');
                continue;
            }
            long div = 2;
            long res = n;
            while (n != 1) {
                if (n % div == 0) {
                    while (n % div == 0)
                        n /= div;
                    res *= 1 - (double) 1 / div;
                }
                div++;
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}
