import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static StringBuilder res = new StringBuilder();

    private void print(int from, int to) {
        res.append(from).append(' ').append(to).append('\n');
    }

    private void f(int n, int from, int mid, int to) {
        if (n <= 1) {
            print(from, to);
            return;
        }
        f(n-1, from, to, mid);
        print(from, to);
        f(n-1, mid, from, to);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(new BigInteger("2").pow(n).subtract(BigInteger.ONE).toString());
        if (n>20)
            return;
        f(n, 1, 2, 3);
        System.out.print(res);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
