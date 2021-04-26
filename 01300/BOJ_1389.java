import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n+1][n+1];
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = true;
        }
        int min = Integer.MAX_VALUE;
        int minNum = 0;
        for (int i = 1; i <= n; i++) {
            Queue<Pos> q = new LinkedList<>();
            boolean[] v = new boolean[n+1];
            v[i] = true;
            q.add(new Pos(i, 0));
            int cnt = 0;
            while (!q.isEmpty()) {
                Pos tmp = q.poll();
                cnt += tmp.d;
                for (int k = 1; k <= n; k++) {
                    if (v[k] || !arr[tmp.n][k])   continue;
                    q.add(new Pos(k, tmp.d+1));
                    v[k] = true;
                }
            }
            if (min > cnt) {
                min = cnt;
                minNum = i;
            }
        }
        System.out.println(minNum);
    }
}
class Pos {
    int n, d;
    public Pos (int n, int d) {this.n=n; this.d=d;}
}
