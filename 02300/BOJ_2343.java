import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int n, m;
    int[] arr;

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) max = max(max, arr[i] = Integer.parseInt(st.nextToken()));

        int start = max(max, n/m+(n%m==0?0:1));
        int end = 1000000000;
        while (start<=end) {
            int mid = (start+end)/2;
            if (!isPossible(mid))
                start = mid+1;
            else
                end = mid-1;
        }

        System.out.println(start);
    }

    private boolean isPossible(final int limit) {
        int idx = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            while (idx<n && sum <= limit) {
                if (sum+arr[idx] > limit) break;
                sum += arr[idx++];
            }
        }
        return idx == n;
    }
}
