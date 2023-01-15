import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        boolean isReverse = false;
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isHourGlass = st.nextToken().charAt(0) == 'H';
            int num = Integer.parseInt(st.nextToken());
            cur += (isReverse?-1:1);
            if (cur<=0) cur = 12;
            if (cur==13) cur = 1;
            boolean clap = false;
            if (isHourGlass && cur != num) {
                isReverse = !isReverse;
            }
            if (cur==num && !isHourGlass)
                clap = true;
            sb.append(cur).append(' ').append(clap?"YES":"NO").append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
