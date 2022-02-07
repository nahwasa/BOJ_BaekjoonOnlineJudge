import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[102];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            cnt[cur]++;
            sum += cur;
        }

        long s = sum;
        long answer = 0;
        for (int a = 1; a <= 101; a++) {
            int c = cnt[a];
            answer += 1l*a*(c*s-a*(c*(c+1)/2));
            s -= c*a;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
