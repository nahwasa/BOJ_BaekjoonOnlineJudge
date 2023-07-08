import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append(s).append(' ').append(a+b+c).append(' ');

            if (a+b+c>=55 && a>=35.0*0.3 && b>=25.0*0.3 && c>=40.0*0.3) {
                sb.append("PASS");
            } else {
                sb.append("FAIL");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
