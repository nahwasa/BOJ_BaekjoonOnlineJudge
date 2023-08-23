import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String a = br.readLine();
        String b = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            sb.append(ac>bc?ac:bc);
        }
        System.out.println(sb);
    }
}
