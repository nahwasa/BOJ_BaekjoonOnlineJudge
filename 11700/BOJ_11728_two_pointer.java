import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (idx < n && cur > a[idx]) res.append(a[idx++]).append(' ');
            res.append(cur).append(' ');
        }
        while (idx < n) res.append(a[idx++]).append(' ');
        System.out.println(res);

    }
}
