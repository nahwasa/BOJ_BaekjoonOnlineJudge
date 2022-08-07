import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sqrtN = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrtN; i++) {
            if (N%i == 0) {
                System.out.println(N-N/i);
                return;
            }
        }
        System.out.println(N-1);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
