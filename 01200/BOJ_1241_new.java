import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr[i] = cur;
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        }
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int limit = (int)Math.sqrt(cur);
            cnt[i] = limit*limit==cur?-hm.getOrDefault(limit, 0):0;
            for (int j = 1; j <= limit; j++) {
                if (cur%j!=0) continue;
                cnt[i] += hm.getOrDefault(j, 0) + hm.getOrDefault(cur/j, 0);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(cnt[i]-1).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
