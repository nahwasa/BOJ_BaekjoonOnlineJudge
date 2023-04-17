import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int limit = (int) Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            for (int j = i; j <= n/i; j++) {
                if (i*j <= n) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
