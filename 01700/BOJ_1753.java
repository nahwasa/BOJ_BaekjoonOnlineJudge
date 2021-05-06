import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 3000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        LinkedList<Pos>[] arr = new LinkedList[n+1];
        for (int i = 1; i <= n; i++)    arr[i] = new LinkedList<>();
        while (e-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(new Pos(b, Integer.parseInt(st.nextToken())));
        }
        boolean[] v = new boolean[n+1];
        int[] d = new int[n+1];
        Arrays.fill(d, MAX);
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.add(new Pos(start, d[start]));
        // solve
        while (!pq.isEmpty()) {
            Pos tmp = pq.poll();
            if (v[tmp.n]) continue;
            v[tmp.n] = true;
            for (Pos p : arr[tmp.n]) {
                int cd = d[p.n];
                int nd = d[tmp.n] + p.d;
                d[p.n] = Math.min(d[p.n], d[tmp.n] + p.d);
                pq.add(new Pos(p.n, d[p.n]));
            }
        }
        // print
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(d[i]==MAX ? "INF" : d[i]).append('\n');
        System.out.print(sb);
    }
}
class Pos implements Comparable<Pos> {
    int n, d;
    public Pos(int v, int d) {this.n =v; this.d=d;}

    @Override
    public int compareTo(Pos o) {
        return this.d-o.d;
    }
}
