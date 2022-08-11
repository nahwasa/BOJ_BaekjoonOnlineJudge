import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private boolean chk(int num) {
        int[] chk = new int[10];
        while (num != 0) {
            if (++chk[num%10] == 2)
                return false;
            num /= 10;
        }
        return true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int num = n; num <= m; num++) {
                if (chk(num))
                    cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
