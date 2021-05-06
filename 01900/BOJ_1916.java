import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Pos>[] arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)    arr[i] = new ArrayList<>();
        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(new Pos(b, Integer.parseInt(st.nextToken())));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        //solve
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(start, 0));
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[start] = 0;
        boolean[] v = new boolean[n+1];
        while (!pq.isEmpty()) {
            Pos tmp = pq.poll();
            if (v[tmp.n]) continue;
            v[tmp.n] = true;
            for (Pos pos : arr[tmp.n]) {
                int nx = res[tmp.n] + pos.dist;
                res[pos.n] = Math.min(res[pos.n], nx);
                if (res[pos.n] == nx)   pq.add(new Pos(pos.n, nx));
            }
        }
        //print
        System.out.println(res[end]);
    }
}
class Pos implements Comparable<Pos> {
    int n, dist;
    public Pos(int n, int dist) {this.n=n; this.dist=dist;}

    @Override
    public int compareTo(Pos o) {
        return this.dist - o.dist;
    }
}
