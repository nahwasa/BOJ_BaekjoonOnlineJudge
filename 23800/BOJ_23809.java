import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void print(int n, StringBuilder sb, int gap) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append('@');
            }
            for (int j = 0; j < gap*n; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < n; j++) {
                sb.append('@');
            }
            if (gap == 0) {
                for (int j = 0; j < n; j++) {
                    sb.append('@');
                }
            }
            sb.append('\n');
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        print(n, sb, 3);
        print(n, sb, 2);
        print(n, sb, 0);
        print(n, sb, 2);
        print(n, sb, 3);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
