import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int min = 200;
        int a = 0;
        int b = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i*j < n) continue;
                if (min > i+j) {
                    min = i+j;
                    a=i;
                    b=j;
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
