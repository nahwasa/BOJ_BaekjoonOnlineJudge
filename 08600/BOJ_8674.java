import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long r = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long a = r/2 * c;
        long b = r*c - a;
        long gap = Math.abs(a-b);

        a = r * (c/2);
        b = r*c - a;
        gap = Math.min(gap, Math.abs(a-b));

        System.out.println(gap);
    }
}
