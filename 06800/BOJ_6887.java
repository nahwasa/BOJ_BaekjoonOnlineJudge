import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 10000; i >= 1; i--) {
            if (i*i <= n) {
                System.out.println("The largest square has side length " + i + ".");
                return;
            }
        }
    }
}
