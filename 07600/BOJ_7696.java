import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1000001];

        int cnt = 1000000;
        int cur = 1;
        while (cnt != 0) {
            boolean ok = true;
            int[] v = new int[10];
            int tmp = cur;
            while (tmp != 0) {
                if (++v[tmp%10] > 1) {
                    ok = false;
                    break;
                }
                tmp /= 10;
            }
            if (ok)
                arr[1000001 - cnt--] = cur;
            cur++;
            if (cur % 50000 == 0) System.gc();
        }

        while (true) {
            int in = Integer.parseInt(br.readLine());
            if (in == 0)    break;
            System.out.println(arr[in]);
        }
    }
}
