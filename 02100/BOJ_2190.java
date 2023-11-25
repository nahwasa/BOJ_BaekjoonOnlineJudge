import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[][] arr = new long[n][2];
        Set<Long> xEx = new HashSet<>();
        Set<Long> yEx = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            xEx.add(arr[i][0]);
            yEx.add(arr[i][1]);
        }

        int answer = 0;
        for (Long curX : xEx) {
            for (Long curY : yEx) {

                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i][0] >= curX && arr[i][1] >= curY && arr[i][0] <= curX + a && arr[i][1] <= curY + b) {
                        cnt++;
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(answer);
    }
}
