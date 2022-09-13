import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        while (n-->0) {
            String cur = br.readLine();
            hm.put(cur, hm.getOrDefault(cur, 0)+1);
        }
        for (String key : hm.keySet()) {
            if (hm.get(key)%k!=0) {
                System.out.println(key);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
