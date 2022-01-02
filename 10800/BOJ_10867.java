import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] negArr = new boolean[1001];
        boolean[] posArr = new boolean[1001];
        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur < 0) {
                negArr[-cur] = true;
            } else {
                posArr[cur] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1000; i > 0; i--) {
            if (negArr[i])
                sb.append(-i).append(' ');
        }
        for (int i = 0; i <= 1000; i++) {
            if (posArr[i])
                sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
