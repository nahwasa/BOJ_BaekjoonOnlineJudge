import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        int total = 0;
        int max = 0;
        String maxStr = null;
        while (n-->0) {
            String cur = br.readLine();
            if (!hm.containsKey(cur))
                hm.put(cur, 0);
            hm.put(cur, hm.get(cur)+1);
            if (hm.get(cur) > max) {
                max = hm.get(cur);
                maxStr = cur;
            }
            total++;
        }

        System.out.println(max > total/2 ? maxStr : "NONE");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
