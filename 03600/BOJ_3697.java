import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pos implements Comparable<Pos> {
    int r, c, height;
    public Pos(int r, int c, int height) {
        this.r = r;
        this.c = c;
        this.height = height;
    }

    @Override
    public int compareTo(Pos o) {
        if (this.height > o.height)
            return -1;
        else if (this.height < o.height)
            return 1;
        return 0;
    }
}

class PosXY {
    int r, c;
    public PosXY(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (tc-->0) {
            // for each case
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] height = new int[r][c];
            int[][] visited = new int[r][c];
            for (int[] tmp : visited)   Arrays.fill(tmp, -1);
            ArrayList<Pos> order = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    height[i][j] = Integer.parseInt(st.nextToken());
                    order.add(new Pos(i, j, height[i][j]));
                }
            }

            // solve
            Collections.sort(order);

            int eachCaseCnt = 0;
            for (int it = 0; it < r*c; it++) {
                Pos cur = order.get(it);
                if (visited[cur.r][cur.c] != -1)
                    continue;
                int startHeight = height[cur.r][cur.c];
                int hmd = startHeight - d; // hmd ; h-d
                if (hmd < 0)   // pass impossible points
                    break;

                int cnt = 0;

                // bfs
                Queue<PosXY> q = new LinkedList<>();
                q.add(new PosXY(cur.r, cur.c));
                visited[cur.r][cur.c] = startHeight;
                boolean isTop = true;

                while (!q.isEmpty()) {
                    PosXY pos = q.poll();

                    if (height[pos.r][pos.c] == startHeight)
                        cnt++;

                    for (int i = 0; i < 4; i++) {
                        int nr = pos.r + dr[i];
                        int nc = pos.c + dc[i];
                        if (nr<0 || nr>=r || nc<0 || nc>=c)
                            continue;
                        if (visited[nr][nc] > visited[pos.r][pos.c])
                            isTop = false;
                        if (visited[nr][nc] != -1 || height[nr][nc] <= hmd)
                            continue;

                        visited[nr][nc] = startHeight;
                        q.add(new PosXY(nr, nc));
                    }
                }
                if (isTop)
                    eachCaseCnt += cnt;
            }
            result.append(eachCaseCnt).append('\n');
        }
        System.out.println(result);
    }
}
