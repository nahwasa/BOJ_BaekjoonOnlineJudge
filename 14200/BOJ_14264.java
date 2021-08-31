import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        double result = Math.sqrt(3) * l * l / 2 * 1 / 2;
        System.out.println(result);
    }
}
