import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        HashSet<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            hs.add(cur);
            if (cur == c) {
                System.out.println(1);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            int remain = c-arr[i];
            if (arr[i] == remain) continue;
            if (hs.contains(remain)) {
                System.out.println(1);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int remain = c-(arr[i]+arr[j]);
                if (remain == arr[i] || remain == arr[j]) continue;
                if (hs.contains(remain)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
