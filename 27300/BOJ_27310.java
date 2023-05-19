import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        int colon = 0;
        int under = 0;
        int score = s.length();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ':') colon++;
            else if (c == '_') under++;
        }

        score += colon;
        score += under*5;
        System.out.println(score);
    }
}
