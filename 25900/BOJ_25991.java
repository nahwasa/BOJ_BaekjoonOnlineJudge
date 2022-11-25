import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double sum = 0d;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            double cur = Double.parseDouble(st.nextToken());
            sum += Math.pow(cur, 3);
        }
        System.out.println(Math.cbrt(sum));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
