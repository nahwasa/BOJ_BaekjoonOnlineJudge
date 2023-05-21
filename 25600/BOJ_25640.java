import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n-->0) {
            if (br.readLine().equals(s)) cnt++;
        }

        System.out.println(cnt);
    }
}
