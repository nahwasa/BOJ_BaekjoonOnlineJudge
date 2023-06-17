import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int l = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        System.out.println(2*t-l);
    }
}
