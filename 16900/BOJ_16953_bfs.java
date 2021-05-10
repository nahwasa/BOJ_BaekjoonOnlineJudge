import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] LIMIT = {100000000, 500000001};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // input buffer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(a, 1));
        HashSet<Integer> hs = new HashSet<>();
        int[] nx = new int[2];
        while (!q.isEmpty()) {
            Pos p = q.poll();
            if (p.n == b) {
                System.out.println(p.d);
                return;
            }
            nx[0] = p.n>=LIMIT[0] ? -1 : p.n * 10 + 1;
            nx[1] = p.n>=LIMIT[1] ? -1 : p.n * 2;
            for (int i = 0; i < 2; i++) {
                if (nx[i] > b || nx[i] < 0 || hs.contains(nx[i]))   continue;
                 q.add(new Pos(nx[i], p.d+1));
            }
        }
        System.out.println(-1);
    }
}

class Pos {
    int n, d;
    public Pos(int n, int d) {
        this.n = n;
        this.d = d;
    }
}
