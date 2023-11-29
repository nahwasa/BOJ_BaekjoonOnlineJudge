import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int MAX = 300000;
    private static final int MIN = -1;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        String s = br.readLine();
        TreeSet<Integer> a = new TreeSet<>();
        TreeSet<Integer> b = new TreeSet<>();
        TreeSet<Integer> c = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur) {
                case 'A': a.add(i); break;
                case 'B': b.add(i); break;
                case 'C': c.add(i); break;
            }
        }
        a.add(MAX); a.add(MIN);
        b.add(MAX); b.add(MIN);
        c.add(MAX); c.add(MIN);

        int cur = c.higher(MIN);
        int cnt = 0;
        while (cur != MAX) {
            int bPos = b.higher(MIN);
            if (bPos < cur) {
                c.remove(cur);
                b.remove(bPos);
                cnt++;
            };

            cur = c.higher(cur);
        }

        cur = a.lower(MAX);
        while (cur != MIN) {
            int bPos = b.lower(MAX);
            if (bPos > cur) {
                a.remove(cur);
                b.remove(bPos);
                cnt++;
            }

            cur = a.lower(cur);
        }

        System.out.println(cnt);
    }
}
