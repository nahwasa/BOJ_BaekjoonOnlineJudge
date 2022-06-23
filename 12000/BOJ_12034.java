import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n*2];
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < 2*n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
            }
            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 2*n-1; i >= 1; i--) {
                int cur = arr[i];
                if (hm.get(cur) == 0) continue;
                hm.put(cur, hm.get(cur)-1);
                int salePrice = cur-cur/4;
                answer.add(salePrice);
                hm.put(salePrice, hm.get(salePrice)-1);
            }
            sb.append(String.format("Case #%d: ", tc));
            for (int i = n-1; i >= 0; i--) sb.append(answer.get(i)).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
