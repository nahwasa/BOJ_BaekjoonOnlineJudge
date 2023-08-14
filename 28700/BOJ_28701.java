import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int sum = (1+n)*n/2;
        System.out.println(sum);
        System.out.println(sum*sum);
        System.out.println(sum*sum);
    }
}
