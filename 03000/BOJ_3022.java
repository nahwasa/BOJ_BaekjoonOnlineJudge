import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        int ans = 0;
        while (n-->0) {
            String cur = br.readLine();
            if (cnt-hm.getOrDefault(cur, 0) < hm.getOrDefault(cur, 0)) {
                ans++;
            }
            cnt++;
            hm.put(cur, hm.getOrDefault(cur, 0)+1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
