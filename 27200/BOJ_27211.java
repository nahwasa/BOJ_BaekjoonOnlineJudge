import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {0,0,-1,1};
    private static final int[] DC = {-1,1,0,0};
    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(st.nextToken()) == 0)
                    map[i][j] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!map[i][j]) continue;
                answer++;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                map[i][j] = true;
                while (!q.isEmpty()) {
                    int cr = q.peek()[0];
                    int cc = q.poll()[1];
                    for (int d = 0; d < 4; d++) {
                        int nr = cr+DR[d];
                        int nc = cc+DC[d];
                        if (nr<0) nr+=r;
                        if (nc<0) nc+=c;
                        nr%=r;
                        nc%=c;

                        if (!map[nr][nc]) continue;
                        map[nr][nc] = false;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
