import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        System.out.println(4*Math.sqrt(a));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
