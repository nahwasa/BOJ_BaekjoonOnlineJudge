import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

interface Type {
    public static final char POST_OFFICE = 'P';
    public static final char HOUSE = 'K';
    public static final char GROUND = '.';
}

class Pos {
    int r, c, altitude;
    char type;
    public Pos(int r, int c, char type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }
    public boolean isPostOffice() {
        return type == Type.POST_OFFICE;
    }
    public boolean isHouse() {
        return type == Type.HOUSE;
    }
    public boolean isNotGround() {
        return type != Type.GROUND;
    }
}

public class Main {
    Pos start;
    Pos[][] arr;
    int n, min, max, houseCount = 0;
    TreeSet<Integer> ts;
    private static final int[] DR = {1, 0, 0, -1, -1, -1, 1, 1};
    private static final int[] DC = {0, 1, -1, 0, -1, 1, -1, 1};

    private boolean isPossible(int low, int high) {
        boolean[][] v = new boolean[n][n];
        int remain = houseCount;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start.r, start.c});
        v[start.r][start.c] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = cur[0]+DR[d];
                int nc = cur[1]+DC[d];
                if (nr<0||nr>=n||nc<0||nc>=n||v[nr][nc]) continue;
                int nextAltitude = arr[nr][nc].altitude;
                if (nextAltitude<low || nextAltitude>high) continue;
                if (arr[nr][nc].isHouse())
                    remain--;
                if (remain == 0)
                    return true;
                v[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return false;
    }

    private int getAnswer() {
        int low = ts.pollFirst();
        int high = max;
        int answer = 1000001;

        while (low <= min) {
            if (isPossible(low, high)) {
                answer = Math.min(answer, high - low);
                if (ts.isEmpty())
                    break;
                low = ts.pollFirst();
            } else {
                if (ts.isEmpty())
                    break;
                if (ts.higher(high) == null)
                    break;
                high = ts.higher(high);
            }
        }

        return answer;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Pos[n][n];
        min = 1000001;
        max = 0;
        start = null;
        for (int r = 0; r < n; r++) {
            String row = br.readLine();
            for (int c = 0; c < n; c++) {
                arr[r][c] = new Pos(r, c, row.charAt(c));
                if (arr[r][c].isPostOffice())
                    start = arr[r][c];
                if (arr[r][c].isHouse())
                    houseCount++;
            }
        }
        ts = new TreeSet<>();
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                arr[r][c].altitude = Integer.parseInt(st.nextToken());
                ts.add(arr[r][c].altitude);
                if (arr[r][c].isNotGround()) {
                    min = Math.min(min, arr[r][c].altitude);
                    max = Math.max(max, arr[r][c].altitude);
                }
            }
        }
        System.out.println(getAnswer());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
