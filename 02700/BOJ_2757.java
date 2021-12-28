import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "RC");
            String r = st.nextToken();
            int c = Integer.parseInt(st.nextToken());

            if (r.equals("0") && c == 0) break;

            StringBuilder tmp = new StringBuilder();
            while (c > 0) {
                c--;
                tmp.append((char)('A'+c%26));
                c/=26;
            }
            answer.append(tmp.reverse()).append(r).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
