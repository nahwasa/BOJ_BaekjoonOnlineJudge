import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        BigDecimal bf = new BigDecimal(br.readLine());
        BigDecimal max = bf;
        while (n-->0) {
            BigDecimal cur = new BigDecimal(br.readLine());
            if (bf.compareTo(BigDecimal.ONE) > 0)
                bf = bf.multiply(cur);
            else
                bf = cur;

            if (max.compareTo(bf) < 0)
                max = bf;
        }
        System.out.println(max.setScale(3, BigDecimal.ROUND_HALF_UP).toString());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
