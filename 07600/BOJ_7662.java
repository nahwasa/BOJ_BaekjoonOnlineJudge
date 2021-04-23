import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            TreeSet<Long> ts = new TreeSet<>();
            HashMap<Long, Integer> hm = new HashMap<>();
            while (n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.nextToken().charAt(0) == 'I') {
                    Long tmp = Long.parseLong(st.nextToken());
                    ts.add(tmp);
                    hm.put(tmp, hm.containsKey(tmp) ? hm.get(tmp)+1 : 1);
                    continue;
                }
                if (ts.isEmpty())   continue;
                Long key = st.nextToken().charAt(0) == '1' ? ts.last() : ts.first();
                int cnt = hm.get(key);
                hm.put(key, cnt-1);
                if (cnt == 1)   ts.remove(key);
            }
            res.append(ts.isEmpty() ? "EMPTY\n" : (String.format("%s %s\n", ts.last(), ts.first())));
        }
        System.out.println(res);
    }
}
