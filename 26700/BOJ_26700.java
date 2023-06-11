import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String base =
                " @@@   @@@  \n" +
                "@   @ @   @ \n" +
                "@    @    @ \n" +
                "@         @ \n" +
                " @       @  \n" +
                "  @     @   \n" +
                "   @   @    \n" +
                "    @ @     \n" +
                "     @      ";

        String[] rows = base.split("\n");

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(rows[i]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
