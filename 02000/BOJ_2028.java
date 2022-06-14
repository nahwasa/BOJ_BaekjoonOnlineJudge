import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            int nPow = n*n;
            boolean isNo = false;
            while(n!=0) {
                int a = n%10;
                int b = nPow%10;
                if (a!=b) {
                    sb.append("NO\n");
                    isNo = true;
                    break;
                }
                n/=10;
                nPow/=10;
            }
            if (!isNo) sb.append("YES\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
