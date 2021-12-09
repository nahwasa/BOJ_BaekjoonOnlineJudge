import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws Exception {
        long a = Long.parseLong(br.readLine());
        double r = Math.sqrt(a / Math.PI);
        System.out.println(2*r*Math.PI);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
