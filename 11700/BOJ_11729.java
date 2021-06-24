import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder res = new StringBuilder();
    private static int cnt = 0;

    private static void cntAndPrint(int from, int to) {
        cnt++;
        res.append(from).append(' ').append(to).append('\n');
    }

    private static void f(int n, int from, int mid, int to) {
        if (n <= 1) {
            cntAndPrint(from, to);
            return;
        }
        f(n-1, from, to, mid);
        cntAndPrint(from, to);
        f(n-1, mid, from, to);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(res);
    }
}
