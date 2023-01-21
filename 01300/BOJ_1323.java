import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        new Main().solution(n, k);
    }

    public void solution(int n, int k) throws Exception {
        int len = String.valueOf(n).length();
        long mult = 1;
        for (int i = 0; i < len; i++) mult*=10;

        int cnt = 1;
        Set<Long> set = new HashSet<>();
        long proc = n%k;
        set.add(proc);

        while (true) {
            if (proc == 0) break;
            cnt++;
            proc *= mult;
            proc += n;
            proc %= k;
            if (set.contains(proc)) {
                System.out.println(-1);
                return;
            }
            set.add(proc);
        }
        System.out.println(cnt);
    }
}
