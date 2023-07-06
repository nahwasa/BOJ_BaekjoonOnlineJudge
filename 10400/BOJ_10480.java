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
        while (n-->0) {
            int a = Integer.parseInt(br.readLine());

            sb.append(a).append(" is ").append(a%2==0?"even":"odd").append('\n');
        }

        System.out.print(sb);
    }
}
