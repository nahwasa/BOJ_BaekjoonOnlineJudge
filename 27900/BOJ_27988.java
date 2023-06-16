import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
       new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        Ribbon[] arr = new Ribbon[n];
        for (int i = 0; i < n; i++) arr[i] = new Ribbon(i+1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i].s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i].setup(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i].color = st.nextToken().charAt(0);

        Arrays.sort(arr);

        char curColor = 0;
        int lastNum = -1;
        int lastE = Integer.MIN_VALUE;
        for (Ribbon cur : arr) {
            if (cur.s > lastE) {
                curColor = cur.color;
                lastNum = cur.num;
                lastE = cur.e;
                continue;
            }

            if (cur.color != curColor) {
                System.out.printf("YES\n%d %d\n", lastNum, cur.num);
                return;
            }

            if (cur.e > lastE) {
                lastE = cur.e;
                lastNum = cur.num;
            }
        }

        System.out.println("NO");
    }
}

class Ribbon implements Comparable<Ribbon> {
    int s, e, num;
    char color;

    public Ribbon(int num) {
        this.num = num;
    }

    public void setup(int len) {
        int tmp = s;
        s = tmp-len;
        e = tmp+len;
    }

    @Override
    public int compareTo(final Ribbon o) {
        if (this.s == o.s)
            return this.e-o.e;
        return this.s-o.s;
    }
}
