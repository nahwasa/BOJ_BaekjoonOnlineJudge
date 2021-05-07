import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++)   arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            long price = Long.parseLong(st.nextToken());
            min = Math.min(min, price);
            sum += arr[i] * min;
        }
        System.out.println(sum);
    }
}
