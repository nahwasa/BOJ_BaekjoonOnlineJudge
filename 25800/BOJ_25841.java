import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            String cur = String.valueOf(i);
            for (int j = 0; j < cur.length(); j++)
                if (cur.charAt(j) == c) cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
