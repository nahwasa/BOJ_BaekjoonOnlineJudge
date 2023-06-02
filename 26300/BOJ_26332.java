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
            String cur = br.readLine();
            sb.append(cur).append('\n');

            StringTokenizer st = new StringTokenizer(cur);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = b;
            sum += (a-1)*(b-2);
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
