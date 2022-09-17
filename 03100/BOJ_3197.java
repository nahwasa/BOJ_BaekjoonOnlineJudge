import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private int C;
    private int[] parents;
    private int[] swan = new int[2];
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h]+=parents[l];
        parents[l] = h;
    }

    private int rcToIdx(int r, int c) { return r*C+c; }
    private boolean isSwanMeet() { return find(swan[0]) == find(swan[1]); }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = C = Integer.parseInt(st.nextToken());
        parents = new int[r*c];
        Arrays.fill(parents, -1);
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(map[i], -1);
        int swanIdx = 0;
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = row.charAt(j);
                switch (ch) {
                    case 'L': swan[swanIdx++] = rcToIdx(i,j);
                    case '.': map[i][j] = 0; break;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) continue;
                boolean isQueueCandidate = false;
                for (int d = 0; d < 4; d++) {
                    int nr = i + DR[d];
                    int nc = j + DC[d];
                    if (nr<0||nr>=r||nc<0||nc>=c) continue;
                    if (map[nr][nc] != -1) union(rcToIdx(i,j), rcToIdx(nr,nc));
                    else isQueueCandidate = true;
                }
                if (isQueueCandidate)
                    q.add(new int[]{i,j,0});
            }
        }

        if (isSwanMeet()) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int dist = cur[2];
            for (int d = 0; d < 4; d++) {
                int nr = cr + DR[d];
                int nc = cc + DC[d];
                if (nr<0||nr>=r||nc<0||nc>=c) continue;
                union(rcToIdx(cr,cc), rcToIdx(nr,nc));

                if (isSwanMeet()) {
                    System.out.println(map[nr][nc]);
                    return;
                }

                if (map[nr][nc] != -1) continue;
                map[nr][nc] = dist+1;
                q.add(new int[]{nr,nc,dist+1});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
