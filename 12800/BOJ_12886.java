import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    boolean[][] v = new boolean[2000][2000];
    int s, t;
    boolean possible = false;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        s = a+b+c;
        if (s%3!=0) {
            System.out.println(0);
            return;
        }
        t = s/3;

        find(a, b);
        find(b, c);
        find(a, c);

        System.out.println(possible?1:0);
    }

    private void find(int a, int b) {
        if (a==t && b==t) possible = true;
        if (possible || a==b || v[a][b] || v[b][a]) return;
        v[a][b] = true;

        int c = s-a-b;
        if (a<b) {
            b-=a;
            a*=2;
        } else {
            a-=b;
            b*=2;
        }

        find(a, b);
        find(b, c);
        find(a, c);
    }
}
