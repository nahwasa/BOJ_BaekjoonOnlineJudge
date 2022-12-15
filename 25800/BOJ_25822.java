import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();
        int strict = 0;
        if (c.compareTo("1.98")>=0)
            strict = 2;
        else if (c.compareTo("0.99")>=0)
            strict = 1;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + (cur==0?1:0);
            max = Math.max(max, cur);
        }

        int s = 1, e = 1;
        int maxStrict = 0;
        while (e <= n) {
            int need = arr[e]-arr[s-1];
            if (need <= strict) {
                maxStrict = Math.max(maxStrict, e-s+1);
                e++;
            } else {
                s++;
                if (s>e)
                    e++;
            }
        }
        System.out.println(maxStrict);
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
