import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;
        int bonus = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'X') {
                bonus = 0;
                continue;
            }
            sum += i+1 + bonus++;
        }
        System.out.println(sum);
    }
}
