import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken()) - 1;
        int sr = r - Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j)=='*';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc, 0});
        arr[sr][sc] = true;
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cnt = cur[2];
            answer = cnt;
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    int nr = cr+dr;
                    int nc = cc+dc;
                    if (nr<0||nr>=r||nc<0||nc>=c||arr[nr][nc]) continue;
                    arr[nr][nc] = true;
                    q.add(new int[]{nr, nc, cnt+1});
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
