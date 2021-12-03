import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 3;
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            String s = br.readLine();
            char c = s.charAt(0);
            int max = 0;
            int cnt = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == c) max = Math.max(max, ++cnt);
                else {
                    cnt = 0;
                    c = s.charAt(i);
                }
            }
            sb.append(max+1).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
