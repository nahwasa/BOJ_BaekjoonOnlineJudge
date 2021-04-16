import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Num> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(new Num(Integer.parseInt(st.nextToken()), i));
            while (pq.peek().idx <= i-l)   pq.poll();
            sb.append(pq.peek().n).append(' ');
        }
        System.out.println(sb);
    }
}
class Num implements Comparable<Num> {
    int n, idx;
    public Num(int n, int idx) {this.n=n; this.idx=idx;}

    @Override
    public int compareTo(Num ano) {
        return this.n - ano.n;
    }
}
