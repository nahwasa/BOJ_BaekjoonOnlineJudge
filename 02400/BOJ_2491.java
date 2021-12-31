import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 1;
        int incCnt = 1;
        int decCnt = 1;

        int bf = Integer.parseInt(st.nextToken());
        n--;

        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());

            if (cur==bf) {
                incCnt++;
                decCnt++;
                continue;
            }

            // inc chk
            if (cur < bf) {
                max = Math.max(max, incCnt);
                incCnt = 1;
            } else {
                incCnt++;
            }

            // dec chk
            if (cur > bf) {
                max = Math.max(max, decCnt);
                decCnt = 1;
            } else {
                decCnt++;
            }

            bf = cur;
        }
        
        max = Math.max(max, Math.max(incCnt, decCnt));
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
