import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    ArrayList<Integer> list = new ArrayList<>();

    private void initPn(int n) {
        boolean[] pn = new boolean[n+1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int base = i+i;
            while (base <= n) {
                pn[base] = true;
                base += i;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!pn[i]) list.add(i);
        }
    }

    private int proc(int num) {
        int sum = 0;
        while (num!=0) {
            int digit = num%10;
            num/=10;
            sum += digit*digit;
        }
        return sum;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        initPn(n);
        StringBuilder answer = new StringBuilder();
        for (int pn : list) {
            int def = pn;
            HashSet<Integer> hs = new HashSet<>();
            do {
                hs.add(pn);
                pn = proc(pn);
            } while (!hs.contains(pn) && pn!=1);
            if (pn == 1)
                answer.append(def).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
