import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, TreeSet<Pos>> rMap = new HashMap<>();
        Map<Integer, TreeSet<Pos>> cMap = new HashMap<>();

        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (!rMap.containsKey(r)) rMap.put(r, new TreeSet<>((o1, o2) -> o1.c - o2.c));
            if (!cMap.containsKey(c)) cMap.put(c, new TreeSet<>((o1, o2) -> o1.r - o2.r));

            Pos pos = new Pos(r, c);
            rMap.get(r).add(pos);
            cMap.get(c).add(pos);
        }

        String dir = br.readLine();
        Pos cur = new Pos(0, 0);
        for (int i = 0; i < m; i++) {
            switch (dir.charAt(i)) {
                case 'R': cur = rMap.get(cur.r).higher(cur); break;
                case 'L': cur = rMap.get(cur.r).lower(cur); break;
                case 'U': cur = cMap.get(cur.c).higher(cur); break;
                case 'D': cur = cMap.get(cur.c).lower(cur); break;
            }
        }
        System.out.println(cur);
    }
}

class Pos {
    int r, c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return c + " " + r;
    }
}
