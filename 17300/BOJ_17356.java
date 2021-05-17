import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double calc = b-a;
        calc /= 400f;
        calc = Math.pow(10, calc) + 1f;
        calc = 1 / calc;
        System.out.println(String.format("%.5f", calc));
    }
}
