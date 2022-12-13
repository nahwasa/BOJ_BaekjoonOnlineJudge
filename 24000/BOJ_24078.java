import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 21;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine()) % MOD);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
