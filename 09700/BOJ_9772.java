import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);

            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            if (a == 0 || b == 0) {
                sb.append("AXIS");
            } else if (a > 0 && b > 0) {
                sb.append("Q1");
            } else if (a > 0 && b < 0) {
                sb.append("Q4");
            } else if (a < 0 && b < 0) {
                sb.append("Q3");
            } else {
                sb.append("Q2");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
