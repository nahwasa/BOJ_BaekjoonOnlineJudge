import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if (n==1) {
            System.out.println(-1);
            return;
        }
        long div = 1l*k*n / (n-1);
        long mod = 1l*k*n % (n-1);
        System.out.println(div+(mod>0?1:0));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
