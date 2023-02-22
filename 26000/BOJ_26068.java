import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "D-");
            if (Integer.parseInt(st.nextToken()) <= 90)
                cnt++;
        }
        System.out.println(cnt);
    }
}
