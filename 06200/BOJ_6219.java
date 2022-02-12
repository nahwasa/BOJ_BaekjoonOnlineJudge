import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private ArrayList<Integer> getPn(int a, int b) {
        boolean[] chk = new boolean[b+1];
        int sqrt = (int)Math.sqrt(b);
        for (int i = 3; i <= sqrt; i+=2) {
            if (chk[i]) continue;
            int base = i+i;
            while (base <= b) {
                chk[base] = true;
                base += i;
            }
        }

        ArrayList<Integer> pns = new ArrayList<>();
        if (a <= 2) pns.add(2);
        a = Math.max(a, 3);
        if ((a&1)==0) a++;
        for (int i = a; i <= b; i+=2) {
            if (!chk[i]) pns.add(i);
        }
        return pns;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<Integer> pns = getPn(a, b);
        int cnt = 0;
        for (int pn : pns) {
            while (pn != 0) {
                if (pn%10 == d) {
                    cnt++;
                    break;
                }
                pn/=10;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
