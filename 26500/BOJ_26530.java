import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            double sum = 0;
            while (n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                sum += Integer.parseInt(st.nextToken()) * Double.parseDouble(st.nextToken());
            }

            sb.append(String.format("$%.2f\n", sum));
        }

        System.out.print(sb);
    }
}
