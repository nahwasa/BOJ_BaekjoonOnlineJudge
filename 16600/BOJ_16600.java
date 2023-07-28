import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        long a = Long.parseLong(br.readLine());

        double len = Math.sqrt(a);
        System.out.println(len*4);
    }
}
