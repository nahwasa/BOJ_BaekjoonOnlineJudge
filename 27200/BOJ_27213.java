import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (a<=2 || b<=2) {
            System.out.println(a*b);
            return;
        }

        System.out.println(a*b-(a-2)*(b-2));
    }
}
