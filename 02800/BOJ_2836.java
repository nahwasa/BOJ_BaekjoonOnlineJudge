import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Human> humans = new ArrayList<>();
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from <= to) continue;

            humans.add(new Human(from, to));
        }
        humans.sort(Comparator.comparingInt(o -> o.to));

        long ans = m;
        int groupSt = humans.get(0).to;
        int groupEd = humans.get(0).from;
        for (Human cur : humans) {
            if (groupEd < cur.to) {
                ans += (groupEd - groupSt) * 2L;
                groupSt = cur.to;
                groupEd = cur.from;
                continue;
            }

            groupEd = max(groupEd, cur.from);
            groupSt = min(groupSt, cur.to);
        }
        ans += (groupEd - groupSt) * 2L;

        System.out.println(ans);
    }
}

class Human {
    int from;
    int to;

    public Human(final int from, final int to) {
        this.from = from;
        this.to = to;
    }
}
