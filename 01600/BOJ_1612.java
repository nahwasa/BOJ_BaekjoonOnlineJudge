import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int s = 0;
        int cnt = 0;
        Set<Integer> chk = new HashSet<>();
        while (true) {
            cnt++;
            s*=10;
            s+=1;
            s%=n;
            if (s==0) {
                System.out.println(cnt);
                return;
            }
            if (chk.contains(s)) break;
            chk.add(s);
        }
        System.out.println(-1);
    }
}
