import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static final int[] DR = {-1,0,0,1};
    static final int[] DC = {0,-1,1,0};
    int r, c;
    List<Integer>[] edges;
    boolean isCycle = false;
    boolean[] v;
    int[] memoization;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char cur = row.charAt(j);
                map[i][j] = cur=='H'?-1:cur-'0';
            }
        }

        edges = new List[r*c];
        for (int i = 0; i < r*c; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) continue;

                int curIdx = i*c+j;
                for (int d = 0; d < 4; d++) {
                    int nr = i+map[i][j]*DR[d];
                    int nc = j+map[i][j]*DC[d];

                    if (nr<0||nr>=r||nc<0||nc>=c||map[nr][nc]==-1) continue;

                    int nextIdx = nr*c+nc;
                    edges[curIdx].add(nextIdx);
                }
            }
        }

        map = null;

        v = new boolean[r*c];
        memoization = new int[r*c];
        v[0] = true;

        System.out.println(dfs(0));
    }

    private int dfs(int idx) {
        if (memoization[idx] != 0) return memoization[idx];

        int max = 0;
        for (int next : edges[idx]) {

            if (isCycle || v[next]) {
                isCycle = true;
                return -1;
            }

            v[next] = true;

            max = Math.max(max, dfs(next));

            v[next] = false;
        }

        return memoization[idx] = isCycle?-1:1+max;
    }
}
