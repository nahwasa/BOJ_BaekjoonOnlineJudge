import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= n; t++) {
            sb.append("String #").append(t).append('\n');
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                int tmp = str.charAt(i) - 'A';
                tmp = (tmp + 1) % 26;
                sb.append((char)(tmp+'A'));
            }
            sb.append('\n').append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
