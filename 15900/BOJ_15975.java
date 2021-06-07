import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }

            map.get(y).add(x);
        }

        long cnt = 0;
        for (Integer key : map.keySet()) {
            List<Integer> tmp = map.get(key);
            if (tmp.size() == 1)
                continue;
            Collections.sort(tmp);
            cnt += tmp.get(1) - tmp.get(0);
            cnt += tmp.get(tmp.size()-1) - tmp.get(tmp.size()-2);
            for (int i = 1; i <= tmp.size()-2; i++) {
                int bf = tmp.get(i-1);
                int cur = tmp.get(i);
                int af = tmp.get(i+1);
                cnt += Math.min(cur-bf, af-cur);
            }
        }
        System.out.println(cnt);
    }
}
