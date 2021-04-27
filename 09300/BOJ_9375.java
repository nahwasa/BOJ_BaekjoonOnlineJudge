import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            int[] cnt = new int[30];
            HashMap<String, Integer> hm = new HashMap<>();
            while (n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String str = st.nextToken();
                if (hm.containsKey(str)) {
                    cnt[hm.get(str)]++;
                    continue;
                }
                hm.put(str, idx);
                cnt[idx++]++;
            }
            int res = 1;
            for (int i = 0; i < idx; i++)   res *= cnt[i]+1;
            sb.append(res-1).append('\n');
        }
        System.out.print(sb);
    }
}
