import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int k = Integer.parseInt(br.readLine());
        double sum = 25 + k*0.01;
        if (sum < 100) sum = 100;
        if (sum > 2000) sum = 2000;

        System.out.printf("%.2f\n", sum);
    }
}
