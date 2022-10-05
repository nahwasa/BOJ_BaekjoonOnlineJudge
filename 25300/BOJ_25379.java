import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long cntL = 0;
        long cntR = 0;
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur%2 == 0) {
                sum+=idx++;
                cntL += i;
                cntR += n-1-i;
            }
        }
        System.out.println(Math.min(cntL, cntR) - sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
