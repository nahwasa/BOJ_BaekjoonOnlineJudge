import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    class Party implements Comparable<Party> {
        int s, e;
        public Party(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Party o) {
            if (this.e == o.e)
                return o.s - this.s;
            return this.e - o.e;
        }
    }
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = 1;
        while (true) {
            int p = Integer.parseInt(br.readLine());
            if (p == 0) break;
            new Main().solution(tc++, p);
        }
        System.out.print(sb);
    }

    public void solution(int tc, int p) throws Exception {
        List<Party> arr = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()) - 1;
            if (s > e) continue;
            arr.add(new Party(s, e));
        }
        Collections.sort(arr);

        int cnt = 0;
        for (int t = 8; t <= 23; t++) {
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i < arr.size(); i++) {
                    Party cur = arr.get(i);
                    if (cur.s <= t && cur.e >= t) {
                        cnt++;
                        arr.remove(i);
                        break;
                    }
                }
            }
        }

        sb.append(String.format("On day %d Emma can attend as many as %d parties.\n", tc, cnt));
    }
}
