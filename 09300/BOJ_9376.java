import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static final char BLOCK     = '*';
    private static final char DOOR      = '#';
    private static final char PRISONER  = '$';
    private static final char FREEDOM   = '!';
    private static final int[] DR = {0, 0, 1, -1};
    private static final int[] DC = {1, -1, 0, 0};

    class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            new Main().solution();
        }
        System.out.print(sb);
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r+2][c+2];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], FREEDOM);
        }
        ArrayList<Pos> startingPos = new ArrayList<>(3);
        startingPos.add(new Pos(0, 0));
        int totalDoorCount = 0;
        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 1; j <= c; j++) {
                char cur = row.charAt(j-1);
                map[i][j] = cur;

                if (cur == DOOR)
                    totalDoorCount++;
                else if (cur == PRISONER)
                    startingPos.add(new Pos(i, j));
            }
        }

        int[][] answer = new int[r+2][c+2];

        for (Pos pos : startingPos) {
            int[][] v = new int[r+2][c+2];
            for (int[] row : v){
                Arrays.fill(row, 10001);
            }
            Queue<Pos> q = new ArrayDeque<>();
            q.add(pos);
            v[pos.r][pos.c] = 0;

            while (!q.isEmpty()) {
                Pos cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + DR[d];
                    int nc = cur.c + DC[d];
                    if (nr<0||nr>r+1||nc<0||nc>c+1||map[nr][nc] == BLOCK) continue;
                    int nextPassedDoorCount = v[cur.r][cur.c] + (map[nr][nc] == DOOR ? 1 : 0);
                    if (v[nr][nc] <= nextPassedDoorCount) continue;
                    v[nr][nc] = nextPassedDoorCount;
                    q.add(new Pos(nr, nc));
                }
            }
            addAll(answer, v);
        }
        sb.append(getAnswer(answer, map)).append('\n');
    }

    private void addAll(int[][] base, int[][] source) {
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base.length; j++) {
                base[i][j] += source[i][j];
            }
        }
    }

    private int getAnswer(int[][] answer, char[][] map) {
        int min = 10001;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                min = Math.min(min, answer[i][j] - (map[i][j] == DOOR ? 2 : 0));
            }
        }
        return min;
    }
}
