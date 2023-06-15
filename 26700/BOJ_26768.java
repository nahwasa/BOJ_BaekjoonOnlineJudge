import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        s = s.replaceAll("a", "4");
        s = s.replaceAll("e", "3");
        s = s.replaceAll("i", "1");
        s = s.replaceAll("o", "0");
        s = s.replaceAll("s", "5");

        System.out.println(s);
    }
}
