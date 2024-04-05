import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int a, b, c;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        double s = -100000;
        double e = 200000;

        int n = 100;
        while (n-->0) {
            double m = (s+e)/2;
            if (isPositive(s) != isPositive(m)) e = m;
            else s = m;
        }
        System.out.println(s);
    }

    private boolean isPositive(double x) {
        return a*x + b*Math.sin(x) - c >= 0;
    }
}
