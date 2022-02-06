import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            while (s < t && --c>0) s+=i;
            if (s >= t) answer = Math.min(s, answer);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer-t);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
