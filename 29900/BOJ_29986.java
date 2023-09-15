import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        while (n-->0) {
            if (Integer.parseInt(st.nextToken()) <= h) cnt++;
        }

        System.out.println(cnt);
    }
}
