import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        //solve
        int l = 0;
        int h = max + 1;
        while (l + 1 < h) {
            int mid = (l+h) / 2;
            int sum = sum(arr, mid);
            if (m <= sum)
                l = mid;
            else
                h = mid;
        }
        System.out.println(l);
    }

    private static int sum(int[] arr, int len) {
        long tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp += arr[i] / len;
        }
        return tmp > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)tmp;
    }
}
