import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
