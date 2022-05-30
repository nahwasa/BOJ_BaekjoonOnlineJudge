import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String PPAP = "pPAp";
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int find = s.indexOf(PPAP, i);
            if (find == -1) break;
            cnt++;
            i = find+3;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
