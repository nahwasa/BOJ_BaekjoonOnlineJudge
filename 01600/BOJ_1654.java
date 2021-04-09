import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        // binary search
        long s = 1;
        long e = max+1;
        while (s+1<e) {
            long m = (s+e)/2;
            long sum = 0;
            for (int i = 0; i < k; i++) sum += arr[i] / m;
            if (sum >= n)   s = m;
            else            e = m;
        }
        System.out.println(s);
    }
}
