import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n+2; i++) sb.append('@');
        sb.append('\n');
        for (int i = 0; i < n; i++) {
            sb.append('@');
            for (int j = 0; j < n; j++) {
                sb.append(' ');
            }
            sb.append('@');
            sb.append('\n');
        }
        for (int i = 0; i < n+2; i++) sb.append('@');
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
