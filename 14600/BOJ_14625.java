import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private boolean canSee(int a, int n) {
        if (a<1000 && n==0) return true;
        while (a!=0) {
            if (a%10==n) return true;
            a/=10;
        }
        return false;
    }
    private int plusMin(int a) {
        if (a%100 == 59)
            return (a/100+1)*100;
        return ++a;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (s<=e) {
            if (canSee(s, n)) cnt++;
            s = plusMin(s);
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
