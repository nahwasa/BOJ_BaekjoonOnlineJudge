import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bf = Integer.parseInt(st.nextToken());
        int inc = 1;
        int dec = 1;

        int answer = 1;

        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == bf) continue;

            if (bf < cur) {
                answer = max(answer, dec);
                dec = 1;
                inc++;
            } else {
                answer = max(answer, inc);
                inc = 1;
                dec++;
            }

            bf = cur;
        }
        answer = max(answer, max(inc, dec));

        System.out.println(answer);
    }
}
