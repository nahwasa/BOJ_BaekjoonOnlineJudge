import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] parent;

    private static int find(int num) {
        if (parent[num] < 0)    return num;
        return parent[num] = find(parent[num]);
    }
    private static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return -parent[a];
        int l = Math.max(a, b);
        int h = Math.min(a, b);
        parent[h] += parent[l];
        parent[l] = h;
        return -parent[h];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        boolean[][] v = new boolean[n][n];
        Queue<Pos> mainQ = new LinkedList<>();
        Queue<Pos> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = i;
            mainQ.add(new Pos(x-1, y-1));
            v[x-1][y-1] = true;
        }
        // solve
        if (k == 1) {
            System.out.println(0);
            return;
        }
        parent = new int[k+1];
        for (int i = 1; i < parent.length; i++) parent[i] = -1;
        int res = 0;
        while (!mainQ.isEmpty()) {
            while (!mainQ.isEmpty()) {
                Pos tmp = mainQ.poll();
                q.add(tmp);
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (arr[nx][ny] == 0) continue;
                    int chk = union(arr[nx][ny], arr[tmp.x][tmp.y]);
                    if (chk == k) {
                        System.out.println(res);
                        return;
                    }
                }
            }
            while (!q.isEmpty()) {
                Pos tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if (nx<0 || nx>=n || ny<0 || ny>=n || v[nx][ny]) continue;
                    arr[nx][ny] = arr[tmp.x][tmp.y];
                    v[nx][ny] = true;
                    mainQ.add(new Pos(nx, ny));
                }
            }
            res++;
        }
    }
}
class Pos {
    int x, y;
    public Pos(int x, int y) {this.x = x; this.y = y;}
}
