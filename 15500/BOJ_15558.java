import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[2][n+1+k];

        for (int i = 0; i < 2; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                if (tmp.charAt(j) == '0')
                    arr[i][j] = true;
            }
        }

        if (arr[0][0]) {
            System.out.println(0);
            return;
        }

        Queue<SangGun> q = new ArrayDeque<>();
        q.add(new SangGun(0, 0, 0));
        arr[0][0] = false;

        while (!q.isEmpty()) {
            SangGun cur = q.poll();
            if (cur.idx >= n) {
                System.out.println(1);
                return;
            }

            if (!arr[cur.line][cur.idx+1]) {
                arr[cur.line][cur.idx+1] = true;
                q.add(new SangGun(cur.line, cur.idx+1, cur.limit+1));
            }

            if (cur.idx-1 > cur.limit && !arr[cur.line][cur.idx-1]) {
                arr[cur.line][cur.idx-1] = true;
                q.add(new SangGun(cur.line, cur.idx-1, cur.limit+1));
            }

            if (!arr[1-cur.line][cur.idx+k]) {
                arr[1-cur.line][cur.idx+k] = true;
                q.add(new SangGun(1-cur.line, cur.idx+k, cur.limit+1));
            }
        }

        System.out.println(0);
    }
}

class SangGun {
    int line, idx, limit;
    public SangGun(int line, int idx, int limit) {
        this.line = line;
        this.idx = idx;
        this.limit = limit;
    }
}
