import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        String maxStr = "";
        while (n-->0) {
            String cur = br.readLine();
            hm.put(cur, hm.getOrDefault(cur, 0)+1);
            if (max < hm.get(cur)) {
                max = hm.get(cur);
                maxStr = cur;
            } else if (max == hm.get(cur) && maxStr.compareTo(cur) < 0) {
                maxStr = cur;
            }
        }
        System.out.println(String.format("%s %d", maxStr, max));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
