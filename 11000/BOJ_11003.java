import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        LinkedList<Num> ll = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Num cur = new Num(Integer.parseInt(st.nextToken()), i);
            while (!ll.isEmpty() && ll.getLast().n >= cur.n) ll.removeLast();
            ll.addLast(cur);
            while (!ll.isEmpty() && ll.getFirst().idx <= i-l)   ll.removeFirst();
            sb.append(ll.getFirst().n).append(' ');
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
