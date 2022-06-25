import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int calc = 1;
        while (n-->0) calc*=2;
      
        System.out.println(calc);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
