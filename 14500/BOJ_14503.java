import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    
    private static final int BLOCKED = -1;
    private static final int BLANK = 0;
    private static final int CLEAN = 1;

    private int answer = 0;
    private int[][] v;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        v = new int[r + 2][c + 2];
        for (int[] row : v) Arrays.fill(row, BLOCKED);

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                if (st.nextToken().charAt(0) == '0')
                    v[i][j] = BLANK;
            }
        }

        simulation(sr+1, sc+1, d);

        System.out.println(answer);
    }

    private void simulation(int cr, int cc, int d) {
        if (v[cr][cc] == BLOCKED) return;   //2.2

        if (v[cr][cc] == BLANK) {   //1
            answer++;
            v[cr][cc] = CLEAN;
        }

        for (int i = 0; i < 4; i++) {
            d+=3;   //3.1
            d%=4;
            if (v[cr+DR[d]][cc+DC[d]] == BLANK) {
                simulation(cr+DR[d], cc+DC[d], d);    //3.2, 3.3
                return;
            }
        }

        simulation(cr+DR[(d+2)%4], cc+DC[(d+2)%4], d);    // 2.1, 2.2
    }
}
