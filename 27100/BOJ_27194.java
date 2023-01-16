import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long t = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        double a = 1d*m/(x*60);
        double b = 1d*(n-m)/(y*60);
        if (a+b < t) {
            System.out.println(0);
        } else {
            System.out.println((int)(a + b - t + 1));
        }
    }
}
