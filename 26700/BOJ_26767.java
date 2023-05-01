import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i%7==0 && i%11==0) {
                sb.append("Wiwat!");
            } else if (i%7==0) {
                sb.append("Hurra!");
            } else if (i%11==0) {
                sb.append("Super!");
            } else {
                sb.append(i);
            }
            
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
