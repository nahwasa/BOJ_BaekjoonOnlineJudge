import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int max = 0;
            while (n-->0) {
                if (st.nextToken().charAt(0) == 'X') {
                    max = Math.max(max, ++cnt);
                } else {
                    cnt = 0;
                }
            }

            sb.append("The longest contiguous subsequence of X's is of length ").append(max).append('\n');
        }

        System.out.print(sb);
    }
}
