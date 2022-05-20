import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combination(m, n)).append('\n');
        }
        System.out.print(sb);
    }

    private String combination(int m, int n) {
        n = Math.min(n, m-n);
        long nFac = 1l;
        for (int i = 2; i <= n; i++) nFac*=i;
        BigInteger res = BigInteger.ONE;
        while(n-->0) res=res.multiply(new BigInteger(String.valueOf(m--)));
        return res.divide(new BigInteger(String.valueOf(nFac))).toString();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
