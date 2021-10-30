import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String answer = "";
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken()) * 1000000 + Integer.parseInt(st.nextToken()) * 1000 + Integer.parseInt(st.nextToken());
            if (cur > max) {
                max = cur;
                StringBuilder sb = new StringBuilder();
                while (st.hasMoreTokens())
                    sb.append(st.nextToken()).append(' ');
                answer = sb.toString();
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
