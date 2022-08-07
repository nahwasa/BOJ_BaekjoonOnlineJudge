import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sqrtN = (int) Math.sqrt(N);
        if (N%2 == 0) {
            System.out.println(N/2);
            return;
        }
        for (int i = 3; i <= sqrtN; i+=2) {
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
