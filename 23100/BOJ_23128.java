import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        Set<Long> set = new HashSet<>();
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(arr[i] = Long.parseLong(st.nextToken()));
        }

        int cnt = 0;
        for (long cur : arr) {
            long num = cur+1;
            long tmp;
            while ((tmp = num*num - cur*cur) <= 1000000) {
                if (set.contains(tmp)) {
                    cnt++;
                }
                num++;
            }
        }
        System.out.println(cnt);
    }
}
