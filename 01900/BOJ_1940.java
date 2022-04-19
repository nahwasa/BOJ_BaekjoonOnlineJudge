import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hs.add(arr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (hs.contains(m-arr[i]))
                cnt++;
        }
        if (m%2==0 && hs.contains(m/2))
            cnt--;
        System.out.println(cnt/2);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
