import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int size = 2;
    static int sizeUpCnt = 2;
    private static void sizeChk() {
        if (--sizeUpCnt == 0) {
            ++size;
            sizeUpCnt = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        Pos start = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    start = new Pos(i, j, 0);
                }
            }
        }
        int res = 0;
        while (true) {
            Queue<Pos> q = new LinkedList<>();
            boolean[][] v = new boolean[n][n];
            q.add(start);
            v[start.r][start.c] = true;
            LinkedList<Pos> forChoise = new LinkedList<>();
            int limit = -1;
            while (!q.isEmpty()) {
                Pos tmp = q.poll();
                int tmpVal = arr[tmp.r][tmp.c];
                if (limit != -1 && tmp.d > limit)
                    continue;
                if (tmpVal != 0 && tmpVal < size) {
                    forChoise.add(tmp);
                    limit = tmp.d;
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = tmp.r + dr[i];
                    int nc = tmp.c + dc[i];
                    if (nr<0 || nc<0 || nr>=n || nc>=n || v[nr][nc] || arr[nr][nc] > size)  continue;
                    v[nr][nc] = true;
                    q.add(new Pos(nr, nc, tmp.d+1));
                }
            }
            if (forChoise.isEmpty())
                break;
            Collections.sort(forChoise);
            start = forChoise.getFirst();
            res += start.d;
            start.d = 0;
            arr[start.r][start.c] = 0;
            sizeChk();
        }
        System.out.println(res);
    }
}
class Pos implements Comparable<Pos> {
    int r, c, d;
    public Pos(int r, int c, int d) {this.r=r; this.c=c; this.d=d;}

    @Override
    public int compareTo(Pos o) {
        if (this.r == o.r)
            return this.c-o.c;
        return this.r-o.r;
    }
}
