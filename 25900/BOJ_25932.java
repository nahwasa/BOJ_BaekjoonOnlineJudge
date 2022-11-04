import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String s = br.readLine();
            boolean isZack = s.contains("17");
            boolean isMack = s.contains("18");
            sb.append(s).append('\n').append(isZack&&isMack?"both":isZack?"zack":isMack?"mack":"none").append('\n').append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
