import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int[] DR = {-1, 0, 0, 1};
    private static final int[] DC = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int[] parents;
    Map<Integer, int[]> map = new HashMap<>();

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b || !map.containsKey(a) || !map.containsKey(b)) return;

        int hi = parents[a] < parents[b] ? a:b;
        int lo = parents[a] < parents[b] ? b:a;
        parents[hi] += parents[lo];
        parents[lo] = hi;
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        parents = new int[r*c];
        Arrays.fill(parents, -1);

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int reduce = Integer.parseInt(st.nextToken());
            int num = find(a*c+b);
            arr[a][b]-=reduce;

            if (map.containsKey(num)) {
                int[] tmp = map.get(num);
                if (tmp[2] > arr[a][b]) {
                    tmp = new int[]{a, b, arr[a][b], q};
                }

                map.put(num, tmp);
                sb.append(tmp[0]+1).append(' ').append(tmp[1]+1).append('\n');

                continue;
            }

            map.put(num, new int[]{a, b, arr[a][b], q});

            for (int d = 0; d < 4; d++) {
                int nr = a+DR[d];
                int nc = b+DC[d];
                if (nr>=r||nr<0||nc>=c||nc<0) continue;
                int adjNum = find(nr*c+nc);
                if (!map.containsKey(adjNum)) continue;

                int[] tmp1 = map.get(adjNum);
                int[] tmp2 = map.get(find(a*c+b));
                int[] tmp = tmp1;
                if (tmp1[2] > tmp2[2]) tmp = tmp2;
                else if (tmp1[2] < tmp2[2]) tmp = tmp1;
                else if (tmp1[3] > tmp2[3]) tmp = tmp1;
                else tmp = tmp2;

                union(num, adjNum);
                map.put(find(a*c+b), tmp);
            }

            int[] ans = map.get(find(a*c+b));
            sb.append(ans[0]+1).append(' ').append(ans[1]+1).append('\n');
        }
        System.out.print(sb);
    }
}
