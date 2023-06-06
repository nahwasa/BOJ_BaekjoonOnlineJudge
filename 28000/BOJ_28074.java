import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        String search = "MOBIS";
        for (int i = 0; i < search.length(); i++) {
            if (s.indexOf(search.charAt(i)) == -1) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
