import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int over10 = 0;
            if (a>=10) over10++;
            if (b>=10) over10++;
            if (c>=10) over10++;

            sb.append(a).append(' ').append(b).append(' ').append(c).append('\n');
            switch (over10) {
                case 0: sb.append("zilch"); break;
                case 1: sb.append("double"); break;
                case 2: sb.append("double-double"); break;
                case 3: sb.append("triple-double"); break;
            }
            sb.append('\n').append('\n');
        }

        System.out.print(sb);
    }
}
