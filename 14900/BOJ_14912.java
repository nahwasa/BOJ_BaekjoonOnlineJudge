import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int getCnt(int num, int d) {
        int cnt = 0;
        while (num!=0) {
            if (num%10 == d)
                cnt++;
            num/=10;
        }
        return cnt;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getCnt(i, d);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
