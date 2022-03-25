import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    class Room {
        int r, c, left, right;
        public Room(int r, int c, int left, int right) {
            this.r = r;
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                int d = 0;
                switch (row.charAt(j)) {
                    case 'U' : d=0; break;
                    case 'R' : d=1; break;
                    case 'D' : d=2; break;
                    case 'L' : d=3; break;
                }
                arr[i][j] = d;
            }
        }

        Queue<Room> q = new ArrayDeque<>();
        boolean[][][][] v = new boolean[r][c][k+1][k+1];
        q.add(new Room(0, 0, k, k));
        v[0][0][k][k] = true;
        while (!q.isEmpty()) {
            Room cur = q.poll();
            int s = Math.max(-cur.left, -3)-1;
            int e = Math.min(cur.right, 3);
            while (++s<=e) {
                int dir = arr[cur.r][cur.c] + s;
                if (dir < 0) dir+=4;
                if (dir >= 4) dir%=4;

                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];
                int nLeft = cur.left+(s<0?s:0);
                int nRight = cur.right-(s>0?s:0);

                if (nr<0||nr>=r||nc<0||nc>=c||v[nr][nc][nLeft][nRight]) continue;
                if (nr==r-1 && nc==c-1) {
                    System.out.println("Yes");
                    return;
                }

                v[nr][nc][nLeft][nRight] = true;
                q.add(new Room(nr, nc, nLeft, nRight));
            }
        }
        System.out.println("No");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
