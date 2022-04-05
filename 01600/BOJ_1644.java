import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    ArrayList<Integer> pn = new ArrayList<>();

    private void initPn(int n) {
        boolean[] isPn = new boolean[n+1];
        int sqrtN = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= n) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= n; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        initPn(n);
        int st = -1;
        int ed = -1;
        int sum = 0;
        int cnt = 0;
        while (st != pn.size()-1 || ed != pn.size()-1) {
            if (sum < n && ed != pn.size()-1)
                sum += pn.get(++ed);
            else
                sum-=pn.get(++st);

            if (sum == n) cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
