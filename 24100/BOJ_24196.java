import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        int pt = 0;
        StringBuilder sb = new StringBuilder();
        while (pt < s.length()) {
            char c = s.charAt(pt);
            sb.append(c);
            pt += c-'A'+1;
        }
        System.out.println(sb);
    }
}
