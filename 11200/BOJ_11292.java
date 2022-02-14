import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            double max = 0;
            ArrayList<String> answer = new ArrayList<>();
            while (n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                double b = Double.parseDouble(st.nextToken());
                if (b < max) continue;
                if (b > max) answer = new ArrayList<>();
                answer.add(a);
                max = b;
            }
            for (String s : answer) sb.append(s).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
