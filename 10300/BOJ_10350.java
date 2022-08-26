import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2*n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
            if (i+n < arr.length)
                arr[i+n] = arr[i];
        }
        int sum = arr[n];
        for (int i = n+1; i < arr.length; i++) {
            arr[i]+=sum;
        }
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < i+n; j++) {
                int calc = -(arr[j]-arr[i-1]);
                if (calc > 0)
                    cnt += calc/sum+(calc%sum==0?0:1);
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
