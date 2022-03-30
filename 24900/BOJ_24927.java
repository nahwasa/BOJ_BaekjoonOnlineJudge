import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (n-->0) {
            int cur = Integer.parseInt(br.readLine());
            while (cur%2==0) {
                cnt++;
                cur/=2;
            }
        }
        System.out.println(cnt>=k?1:0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
