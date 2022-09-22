import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a==0 && b==0) {
            System.out.println(1);
            return;
        }

        int[] pow = new int[20];
        pow[0] = 1;
        int limit = 0;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 3;
            if (pow[i] > Math.max(a,b)) {
                limit = i-1;
                break;
            }
        }

        for (int i = limit; i >= 0; i--) {
            if (a > b) a-=pow[i];
            else b-=pow[i];
        }
        System.out.println(a==0 && b==0 ? 1 : 0);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
