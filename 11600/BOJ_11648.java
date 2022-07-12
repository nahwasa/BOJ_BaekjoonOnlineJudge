import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n>=10) {
            int cur = 1;
            while (n!=0) {
                cur*=n%10;
                n/=10;
            }
            n = cur;
            cnt++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
