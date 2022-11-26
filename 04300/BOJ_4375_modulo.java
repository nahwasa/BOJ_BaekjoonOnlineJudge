import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder answer = new StringBuilder();
        while ((s=br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int base = 1;
            int cnt = 1;
            while ((base=base%n) != 0) {
                cnt++;
                base = base*10+1;
            }
            answer.append(cnt).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
