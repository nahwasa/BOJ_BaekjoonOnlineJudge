import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s = "";
        for (int i = 1; i <= n; i++) {
            String cur = String.valueOf(i);
            if (!s.contains(cur))
                s+=cur;
        }
        System.out.println(s);
    }
}
