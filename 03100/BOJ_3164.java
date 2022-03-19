import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        long sum = 0;
        for (int i = y1%2==1?y1+1:y1+2; i <= y2; i+=2) {
            if (i <= x1) continue;
            sum += Math.min(i, x2) - x1;
        }
        for (int i = x1%2==1?x1+1:x1+2; i <= x2; i+=2) {
            if (i-1 <= y1) continue;
            sum += Math.min(i-1, y2) - y1;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
