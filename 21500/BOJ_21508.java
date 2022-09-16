import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        while (n-->0) {
            String s = br.readLine();
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9')
                    num.append(c);
            }
            String numStr = num.toString();
            hm.put(numStr, hm.getOrDefault(numStr, 0) + 1);
        }

        int cnt = 0;
        StringBuilder answer = new StringBuilder();
        for (String key : hm.keySet()) {
            if (hm.get(key) >= 1 && hm.get(key) <= 5) {
                answer.append(key).append('\n');
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
