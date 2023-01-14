import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] answer = new long[36];

    private void f(int n) {
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += answer[i]*answer[n-1-i];
        }
        answer[n] = cur;
    }

    private void solution() throws Exception {
        answer[0] = 1;
        for (int i = 1; i <= 35; i++) {
            f(i);
        }
        System.out.println(answer[Integer.parseInt(br.readLine())]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
