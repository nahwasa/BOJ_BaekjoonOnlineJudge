import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                a+=Integer.parseInt(st.nextToken());
                b+=Integer.parseInt(st.nextToken());
            }

            sb.append(a==b?"Draw":a>b?"Yonsei":"Korea").append('\n');
        }

        System.out.print(sb);
    }
}
