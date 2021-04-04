import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] arr;
    private static int m, n;
    private static boolean[][] vTmp;
    private static HashMap<Integer, ArrayList<Integer>> edge;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = st.nextToken().equals("1") ? -1 : -2;
        }

        // set div num
        int div = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < 0) setDiv(arr[i][j], div++, new Pos(i, j));
            }
        }

        // make graph
        edge = new HashMap<>();
        for (int i = 0; i < div; i++)   edge.put(i, new ArrayList<>());
        vTmp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (!vTmp[i][j])  makeGraph(arr[i][j], new Pos(i,j));
        }

        // arr bfs
        int minChange = Integer.MAX_VALUE;
        Queue<Pos> mq = new LinkedList<>();
        vTmp = new boolean[m][n];
        boolean[] mv = new boolean[div];
        mq.add(new Pos(m/2, n/2));
        vTmp[m/2][n/2] = true;
        int cutCnt = 0;

        while (!mq.isEmpty()) {
            Pos mqTmp = mq.poll();
            int mqTmpDivNum = arr[mqTmp.y][mqTmp.x];
            if (!mv[mqTmpDivNum]) {
                mv[mqTmpDivNum] = true;
                if (cutCnt++ > div/2)   break;

                // graph bfs
                Queue<Node> q = new LinkedList<>();
                boolean[] v = new boolean[div];
                q.add(new Node(mqTmpDivNum, 0));
                v[mqTmpDivNum] = true;
                while (true) {
                    Node tmp = q.poll();
                    if (tmp.dist >= minChange)  break;
                    ArrayList<Integer> edgeTmp = edge.get(tmp.n);
                    for (Integer itTmp : edge.get(tmp.n)) {
                        if (v[itTmp])   continue;
                        v[itTmp] = true;
                        q.add(new Node(itTmp, tmp.dist+1));
                    }
                    if (q.isEmpty()) {
                        minChange = Math.min(minChange, tmp.dist);
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = mqTmp.x + dx[i];
                int ny = mqTmp.y + dy[i];
                if (nx<0 || ny<0 || nx>=n || ny>=m || vTmp[ny][nx]) continue;
                vTmp[ny][nx] = true;
                mq.add(new Pos(ny, nx));
            }

            if (div == m*n) break;
        }
        System.out.println(minChange);
        br.close();
    }

    private static void setDiv(int s, int div, Pos p) {
        arr[p.y][p.x] = div;
        for (int d = 0; d < 4; d++) {
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[ny][nx] != s) continue;
            setDiv(s, div, new Pos(ny, nx));
        }
    }

    private static void makeGraph(int s, Pos p) {
        vTmp[p.y][p.x] = true;
        for (int d = 0; d < 2; d++) {
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || vTmp[ny][nx]) continue;
            if (arr[ny][nx] != s) {
                edge.get(s).add(arr[ny][nx]);
                edge.get(arr[ny][nx]).add(s);
                continue;
            }
            makeGraph(s, new Pos(ny, nx));
        }
    }
}
class Pos {
    int x, y;
    public Pos(int y, int x) { this.x=x; this.y=y; }
}
class Node {
    int n, dist;
    public Node(int n, int dist) { this.n=n; this.dist=dist; }
}
