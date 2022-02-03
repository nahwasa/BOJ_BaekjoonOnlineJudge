import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int r = Integer.parseInt(br.readLine());
            int n = 10+r-1;
            r = Math.min(r, n-r);

            long tmp = 1;
            for (int i = 0; i < r; i++) tmp*=n--;
            for (int i = 2; i <= r; i++) tmp/=i;
            sb.append(tmp).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
