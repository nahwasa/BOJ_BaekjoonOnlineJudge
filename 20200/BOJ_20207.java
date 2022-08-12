import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int DAY_OF_YEAR = 365;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[DAY_OF_YEAR+1];
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int i = s; i <= e; i++) {
                cnt[i]++;
            }
        }

        int sum = 0;
        int maxHeight = 0;
        int width = 0;
        for (int i = 0; i <= DAY_OF_YEAR; i++) {
            if (cnt[i] == 0) {
                sum+=maxHeight*width;
                maxHeight = width = 0;
                continue;
            }
            width++;
            maxHeight = Math.max(maxHeight, cnt[i]);
        }
        sum+=maxHeight*width;
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
