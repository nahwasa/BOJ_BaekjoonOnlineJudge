import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long d = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long cnt = n/d + m/d + k/d;
        long max = k;
        long factor1 = (n/d+1)*d-n;
        if (n%d != 0 && k-factor1 >= 0) {
            if (cnt == n/d+1 + m/d + (k-factor1)/d) {
                max = Math.max(max, k-factor1);
            } else if (cnt < n/d+1 + m/d + (k-factor1)/d) {
                cnt = n/d+1 + m/d + (k-factor1)/d;
                max = k-factor1;
            }
        }

        long factor2 = (m/d+1)*d-m;
        if (m%d != 0 && k-factor2 >= 0) {
            if (cnt == n/d + m/d+1 + (k-factor2)/d) {
                max = Math.max(max, k-factor2);
            } else if (cnt < n/d + m/d+1 + (k-factor2)/d) {
                cnt = n/d + m/d+1 + (k-factor2)/d;
                max = k-factor2;
            }
        }

        long factor3 = factor1 + factor2;
        if (n%d != 0 && m%d != 0 && k-factor3 >= 0) {
            if (cnt == n/d+1 + m/d+1 + (k-factor3)/d) {
                max = Math.max(max, k-factor3);
            } else if (cnt < n/d+1 + m/d+1 + (k-factor3)/d) {
                cnt = n/d+1 + m/d+1 + (k-factor3)/d;
                max = k-factor3;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
