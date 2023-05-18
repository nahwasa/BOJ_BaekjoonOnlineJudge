import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        int a = 0;
        int b = 0;

        for (int i = 1; i < s.length(); i+=2) {
            char c = s.charAt(i-1);
            int score = s.charAt(i)-'0';

            if (c == 'A') a++;
            else b++;
        }

        System.out.print(a>b ? 'A' : 'B');
    }
}
