import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private static final int[] DR = {0, 0, 1, -1};
    private static final int[] DC = {1, -1, 0, 0};
    int r, c, modify = -1;
    int[][] arr;
    boolean[][] v;

    private boolean dfs(int r, int c) {
        v[r][c] = true;
        if (modify != -1)
            arr[r][c] = modify;
        if (r==this.r && c==this.c) return true;
        for (int d = 0; d < 4; d++) {
            int nr = r+DR[d];
            int nc = c+DC[d];
            if (arr[nr][nc] == 1 || v[nr][nc]) continue;
            v[nr][nc] = true;
            if (dfs(nr, nc))
                return true;
        }
        return false;
    }

    private void dfs2(int r, int c, int modify) {
        if (modify == 2 && (r==0 && c==1) || (r==this.r && c==this.c+1)) return;
        if (modify == 3 && (r==1 && c==0) || (r==this.r+1 && c==this.c)) return;

        arr[r][c] = modify;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int nr = r + x;
                int nc = c + y;
                if (nr < 0 || nr >= this.r + 2 || nc < 0 || nc >= this.c + 2 || arr[nr][nc] != 1) continue;
                dfs2(nr, nc, modify);
            }
        }
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r+2][c+2];
        for (int[] row : arr) Arrays.fill(row, 1);
        arr[0][0] = arr[r+1][c+1] = 0;
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[r+2][c+2];
        if (!dfs(1, 1)) {
            System.out.println(0);
            return;
        }

        dfs2(1, 0, 2);
        dfs2(0, 1, 3);
        arr[0][1] = arr[1][0] = 1;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i==1&&j==1 || i==r&&j==c) continue;
                if (arr[i][j] != 0) continue;

                boolean is2Exist = false;
                boolean is3Exist = false;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (x==0 && y==0) continue;

                        if (arr[i+x][j+y] == 2) is2Exist = true;
                        else if (arr[i+x][j+y] == 3) is3Exist = true;
                    }
                }

                if (is2Exist && is3Exist) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(2);
    }
}
