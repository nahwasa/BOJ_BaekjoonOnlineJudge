import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int zeroCnt = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur==0) zeroCnt++;
            sum += cur;
        }

        System.out.println(zeroCnt>=(n%2==0?n/2:n/2+1)?"INVALID":sum>0?"APPROVED":"REJECTED");
    }
}
