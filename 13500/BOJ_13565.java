import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int GOAL = 100;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r+2][c];
        Arrays.fill(arr[r+1], GOAL);
        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j)-'0';
            }
        }

        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0));
        arr[0][0] = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            for (int a = -1; a <= 1; a++) {
                for (int b = -1; b <= 1; b++) {
                    if (((a^b)&1)!=1) continue;
                    int nr = cr+a;
                    int nc = cc+b;
                    if (nr<0||nr>r+1||nc<0||nc>=c||arr[nr][nc]==1) continue;
                    if (arr[nr][nc] == GOAL) {
                        System.out.println("YES");
                        return;
                    }
                    arr[nr][nc] = 1;
                    q.add(new Pos(nr, nc));
                }
            }
        }
        System.out.println("NO");
    }
}

class Pos {
    int r, c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
