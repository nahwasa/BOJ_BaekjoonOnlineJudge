import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};
    private static int ROW;
    private static int COL = 10;
    private static int REMOVE_CNT;
    private static final char BLANK = '0';

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
    
    private boolean muyomuyo(char[][] map) {
        boolean result = false;
        boolean[][] v = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == BLANK || v[i][j]) continue;

                int cnt = 1;
                List<int[]> path = new ArrayList<>();
                Queue<int[]> q = new ArrayDeque<>();
                v[i][j] = true;
                q.add(new int[]{i, j});
                path.add(q.peek());
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0]+DR[d];
                        int nc = cur[1]+DC[d];
                        if (nr<0||nr>=ROW||nc<0||nc>=COL||v[nr][nc]||map[nr][nc]!=map[i][j]) continue;
                        v[nr][nc] = true;
                        cnt++;
                        int[] next = new int[]{nr, nc};
                        q.add(next);
                        path.add(next);
                    }
                }
                if (cnt<REMOVE_CNT) continue;
                
                for (int[] cur : path) {
                    map[cur[0]][cur[1]] = BLANK;
                    result = true;
                }
            }
        }
        
        return result;
    }
    
    public char[][] getDropMap(char[][] map) {
        char[][] newMap = new char[ROW][COL];
        for (char[] row : newMap) Arrays.fill(row, BLANK);
        for (int j = 0; j < COL; j++) {
            List<Character> col = new ArrayList<>();
            for (int i = ROW-1; i >= 0; i--) {
                if (map[i][j] == BLANK) continue;
                col.add(map[i][j]);
            }
            for (int i = 0; i < col.size(); i++) {
                newMap[ROW-1-i][j] = col.get(i);
            }
        }
        return newMap;
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        REMOVE_CNT = Integer.parseInt(st.nextToken());

        char[][] map = new char[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            String row = br.readLine();
            for (int j = 0; j < COL; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        while (muyomuyo(map)) {
            map = getDropMap(map);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
