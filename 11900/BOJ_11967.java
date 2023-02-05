import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {0, 0, 1, -1};
    private static final int[] DC = {1, -1, 0, 0};
    private static final int ON = 1;
    private static final int CANDIDATE = 3;
    private static final int VISITED = 2;


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Pos, List<Pos>> map = new HashMap<>();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Pos cur = new Pos(x, y);
            if (map.containsKey(cur)) {
                map.get(cur).add(new Pos(a, b));
            } else {
                List<Pos> list = new ArrayList<>();
                list.add(new Pos(a, b));
                map.put(cur, list);
            }
        }

        Queue<Pos> q = new ArrayDeque<>();
        int[][] v = new int[n+1][n+1];
        v[1][1] = VISITED;
        q.add(new Pos(1, 1));
        int cnt = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (map.containsKey(cur)) {
                for (Pos light : map.get(cur)) {
                    if (v[light.r][light.c] == VISITED || v[light.r][light.c] == ON) continue;
                    cnt++;
                    if (v[light.r][light.c] == CANDIDATE) {
                        q.add(light);
                        v[light.r][light.c] = VISITED;
                    } else {
                        v[light.r][light.c] = ON;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + DR[d];
                int nc = cur.c + DC[d];
                if (nr < 1 || nr > n || nc < 1 || nc > n || v[nr][nc] == VISITED || v[nr][nc] == CANDIDATE) continue;

                if (v[nr][nc] == ON) {
                    v[nr][nc] = VISITED;
                    q.add(new Pos(nr, nc));
                    continue;
                }

                v[nr][nc] = CANDIDATE;
            }
        }
        System.out.println(cnt);
    }
}

class Pos {
    int r, c;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int hashCode() {
        return c*20000+r;
    }

    @Override
    public boolean equals(Object obj) {
        Pos other = (Pos) obj;
        return this.r == other.r && this.c == other.c;
    }
}
