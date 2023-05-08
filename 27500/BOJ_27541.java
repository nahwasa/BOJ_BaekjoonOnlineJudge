import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(s.charAt(n-1) == 'G' ? s.substring(0, n-1) : s+'G');
    }
}
