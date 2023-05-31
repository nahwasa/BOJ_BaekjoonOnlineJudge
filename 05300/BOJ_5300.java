import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(' ');
            if (i%6 == 0) {
                sb.append("Go! ");
            }
        }

        if (n%6!=0) {
            sb.append("Go! ");
        }

        System.out.println(sb);
    }
}
