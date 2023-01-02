import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while (n-->0) {
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println(sum);
    }
}
