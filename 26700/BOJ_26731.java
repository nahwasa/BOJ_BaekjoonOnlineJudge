import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        for (int i = 0; i <= 25; i++) {
            if (s.indexOf('A'+i) == -1) {
                System.out.println((char)('A'+i));
                return;
            }
        }
    }
}
