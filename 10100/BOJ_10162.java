import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int[] TIME = {300, 60, 10};
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] cnt = new int[3];
        for (int i = 0; i < 3; i++) {
            if (t < TIME[i]) continue;
            cnt[i] += t/TIME[i];
            t%=TIME[i];
        }
        System.out.println(t!=0?-1:String.format("%d %d %d", cnt[0], cnt[1], cnt[2]));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
