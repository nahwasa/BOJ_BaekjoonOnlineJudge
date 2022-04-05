import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int GAP = 100000;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        if (x==y) {
            System.out.println(-1);
            return;
        }
        int first = (int)(y*100/x);
        if (first == 99) {
            System.out.println(-1);
            return;
        }
        int cur = first;
        int cnt = 0;
        while (first==cur) {
            cnt+=GAP;
            cur = (int)((y+=GAP)*100/(x+=GAP));
        }
        
        cur = first;
        x-=GAP;
        y-=GAP;
        cnt-=GAP;
        while (first==cur) {
            cnt++;
            cur = (int)(++y*100/++x);
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
