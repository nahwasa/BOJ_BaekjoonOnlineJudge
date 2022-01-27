import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int capacity = m;
        int cnt = 1;
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            if (capacity-cur>=0) capacity-=cur;
            else {
                cnt++;
                capacity = m-cur;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
