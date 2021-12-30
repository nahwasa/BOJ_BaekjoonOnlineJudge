import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a = 0;
        long b = 1;
        for (int i = 1; i < n; i++) {
            long tmp = a+b;
            b = a;
            a = tmp;
        }
        System.out.println(a+b);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
