import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private List<Integer> getPn(int limit) {
        List<Integer> pn = new ArrayList<>();
        boolean[] isPn = new boolean[limit+1];
        int sqrtN = (int)Math.sqrt(limit);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= limit) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= limit; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
        return pn;
    }

    public void solution() throws Exception {
        List<Integer> pn = getPn(5000000);
        Set<Integer> set = new HashSet<>(pn);

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());

            int idx = 0;
            int curPn = pn.get(idx);
            while (curPn <= Math.sqrt(cur)) {
                while (cur % curPn == 0) {
                    cur /= curPn;
                    sb.append(curPn).append(' ');
                }
                curPn = pn.get(++idx);
            }
            if (set.contains(cur)) {
                sb.append(cur);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
