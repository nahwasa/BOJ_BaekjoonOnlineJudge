import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        k -= a;
        if (a == 0 && k == 0 || k < 0 && d > 0 || k > 0 && d < 0 || k % d != 0) {
            System.out.println("X");
            return;
        }
        System.out.println(k / d + 1);
    }

}
