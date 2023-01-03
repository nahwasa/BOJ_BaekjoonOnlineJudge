import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int cur = 1; cur <= n; cur++) {
            boolean isMultipleOf3 = cur%3==0;
            boolean isMultipleOf5 = cur%5==0;

            if (isMultipleOf3 && isMultipleOf5)
                sb.append("DeadMan\n");
            else if (isMultipleOf3)
                sb.append("Dead\n");
            else if (isMultipleOf5)
                sb.append("Man\n");
            else
                sb.append(cur).append(' ');
        }
        System.out.println(sb);
    }
}
