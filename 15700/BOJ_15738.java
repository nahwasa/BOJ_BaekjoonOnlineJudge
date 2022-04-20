import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.skip(2*n-1);
        br.readLine();
        while (m-->0) {
            int i = Integer.parseInt(br.readLine());
            if (i > 0 && i < k) continue;
            if (i < 0 && n+i+1 > k) continue;
            k = i>0 ? i-k+1 : 2*n-k+i+1;
        }
        System.out.println(k);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
