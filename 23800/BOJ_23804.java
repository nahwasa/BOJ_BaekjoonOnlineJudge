import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
             for (int j = 0; j < 5*n; j++) {
                 sb.append('@');
             }
             sb.append('\n');
        }
        for (int i = 0; i < 3*n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append('@');
            }
            sb.append('\n');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5*n; j++) {
                sb.append('@');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
