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
            StringTokenizer st = new StringTokenizer(br.readLine());
            double area = Double.parseDouble(st.nextToken());
            double base = Double.parseDouble(st.nextToken());
            double height = area * 2 / base;

            sb.append(String.format("The height of the triangle is %.2f units\n", height));
        }

        System.out.print(sb);
    }
}
