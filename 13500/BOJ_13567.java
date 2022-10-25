import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = 0;
        int c = 0;
        int dir = 1;
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().charAt(0) == 'T') {
                dir += st.nextToken().charAt(0) == '0' ? -1 : 1;
                if (dir < 0) dir = 3;
                if (dir > 3) dir = 0;
            } else {
                int dist = Integer.parseInt(st.nextToken());
                r += DR[dir]*dist;
                c += DC[dir]*dist;
                if (r >= m || c >= m || r < 0 || c < 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(c + " " + r);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
