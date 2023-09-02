import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(1);
            return;
        }

        int calc = 1;
        for (int i = 1; i <= n; i++) {
            calc *= i;
            calc%=10;
        }
        System.out.println(calc);
    }
}
