import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String REGEX = "^[A-F]?A+F+C+[A-F]?$";

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) sb.append(br.readLine().matches(REGEX)?"Infected!\n":"Good\n");
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
