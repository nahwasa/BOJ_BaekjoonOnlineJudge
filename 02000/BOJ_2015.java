import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }

        long answer = 0l;
        Map<Long, Long> cnt = new HashMap<>();
        cnt.put(0l, 1l);
        for (int i = 1; i <= n; i++) {
            answer += cnt.getOrDefault(arr[i]-k, 0l);
            cnt.put(arr[i], cnt.getOrDefault(arr[i], 0l) + 1);
        }
        System.out.println(answer);
    }
}
