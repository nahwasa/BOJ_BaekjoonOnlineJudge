import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        arr[n+1] = len;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 1, e = len/m+1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (possible(arr, m, mid)) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        System.out.println(s);
    }

    private boolean possible(final int[] arr, final int m, final int want) {
        int remain = m;
        for (int i = 1; i < arr.length && remain >= 0; i++) {
            int gap = arr[i] - arr[i-1];
            if (gap <= want) continue;

            remain -= (gap-1)/want;
        }

        return remain >= 0;
    }
}
