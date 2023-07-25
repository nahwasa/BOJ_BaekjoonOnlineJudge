import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int min = arr[0];
        int i = 0;
        for (; i < n; i++) if ((arr[i]-=min) != 0) break;
        if (i == n) {
            System.out.println(min);
            return;
        }
        int gcd = arr[i++];
        for (; i < n; i++) gcd = gcd(gcd, arr[i]-=min);
        System.out.println(gcd);
    }

    private int gcd(int a, int b) {
        int r = -1;
        while (r!=0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
