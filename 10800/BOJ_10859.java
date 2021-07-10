import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isPrimeNum(long n) {
        if (n == 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static long reverseNum(long n) {
        long res = 0;
        while (n != 0) {
            long tmp = n % 10;
            res *= 10;
            if (tmp == 0 || tmp == 2 || tmp == 5 || tmp == 8 || tmp == 1) res += tmp;
            else if (tmp == 6)  res += 9;
            else if (tmp == 9)  res += 6;
            else    return -1;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        boolean isPrime = isPrimeNum(n);
        if (isPrime) {
            long rN = reverseNum(n);
            if (rN != -1) {
                System.out.println(isPrimeNum(rN) ? "yes" : "no");
                return;
            }
        }
        System.out.println("no");
    }
}
