import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int m = Integer.parseInt(st.nextToken());
            sb.append(lev(m)).append(' ');
        }
        System.out.println(sb);
    }

    private int lev(final int m) {
        if (m == 300) return 1;
        if (m >= 275) return 2;
        if (m >= 250) return 3;
        return 4;
    }
}
