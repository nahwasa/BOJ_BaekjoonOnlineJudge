import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        int factor = n/2+(n%2==1?1:0);
        while (factor>0) {
            cnt++;
            String cur = br.readLine();
            if (hs.contains(cur)) {
                factor--;
                hs.remove(cur);
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
