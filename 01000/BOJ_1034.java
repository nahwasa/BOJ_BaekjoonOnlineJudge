import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] input = new String[n];
        for (int i = 0; i < n; i++)
            input[i] = br.readLine();

        int k = Integer.parseInt(br.readLine());
        boolean isEven = (k&1)==0;

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tmp = input[i];
            if (hm.containsKey(tmp)) {
                hm.put(tmp, hm.get(tmp)+1);
                continue;
            }

            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (tmp.charAt(j) == '0')
                    cnt++;
            }
            if (cnt > k || (k&1) != (cnt&1))
                continue;
            hm.put(tmp, 1);
        }

        int max = 0;
        for (String key : hm.keySet())
            max = Math.max(max, hm.get(key));

        System.out.println(max);
    }
}
