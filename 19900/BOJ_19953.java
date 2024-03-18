import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MOD = 10;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v0 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int tmp = (v0*m)%MOD;
        int base = tmp;
        int cnt = 0;
        int y = 0;
        int x = 0;
        for (int i = 0; i < 40; i++) {
            if (i!=0 && i%4 == 0 && tmp == base) break;
            cnt++;

            switch (i%4) {
                case 0: x+=tmp; break;
                case 1: y-=tmp; break;
                case 2: x-=tmp; break;
                case 3: y+=tmp; break;
            }

            tmp = (tmp*m)%MOD;
        }

        int resY = v0;
        int resX = 0;
        t--;
        resY += y * (t/cnt);
        resX += x * (t/cnt);

        for (int i = 0; i < t%cnt; i++) {
            switch (i%4) {
                case 0: resX+=tmp; break;
                case 1: resY-=tmp; break;
                case 2: resX-=tmp; break;
                case 3: resY+=tmp; break;
            }
            tmp = (tmp*m)%MOD;
        }

        System.out.println(resX + " " + resY);
    }
}
