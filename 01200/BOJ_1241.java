import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            if (!cnt.containsKey(tmp))
                cnt.put(tmp, 1);
            else
                cnt.put(tmp, cnt.get(tmp) + 1);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sqrt = (int) Math.sqrt(arr[i]);
            for (int k = 1; k <= sqrt; k++) {
                if (arr[i] % k != 0)    continue;
                res[i] += cnt.getOrDefault(k, 0) + (k*k == arr[i] ? 0 : cnt.getOrDefault(arr[i] / k, 0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i] - 1).append('\n');
        }
        System.out.println(sb);
    }
}
