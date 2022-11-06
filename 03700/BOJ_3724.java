import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            BigInteger[] arr = new BigInteger[c];
            for (int i = 0; i < c; i++) arr[i] = BigInteger.ONE;
            while (r-->0) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < c; i++) {
                    arr[i] = arr[i].multiply(new BigInteger(st.nextToken()));
                }
            }
            BigInteger max = arr[0];
            int maxIdx = 0;
            for (int i = 1; i < c; i++) {
                if (max.compareTo(arr[i])<=0) {
                    max = arr[i];
                    maxIdx = i;
                }
            }
            sb.append(maxIdx+1).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
