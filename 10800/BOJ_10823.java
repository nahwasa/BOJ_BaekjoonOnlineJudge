import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            sb.append(s);
        }
        int sum = 0;
        StringTokenizer st = new StringTokenizer(sb.toString(), ",");
        while (st.hasMoreTokens()) sum += Integer.parseInt(st.nextToken());
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
