import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String str = br.readLine();
        int a = 0;
        int b = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            a += c=='A'?1:0;
            b += c=='B'?1:0;
        }

        System.out.printf("%d : %d\n", a, b);
    }
}
