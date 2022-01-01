import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    private static final int MAX = 1000000;
    TreeSet<Integer> pn;

    private void initPrimeNum() {
        pn = new TreeSet<>();
        boolean[] arr = new boolean[MAX+1];
        int sqrtMax = (int) Math.sqrt(MAX);

        for (int base = 3; base <= sqrtMax; base+=2) {
            if (arr[base]) continue;
            int tmp = base+base;

            while (tmp <= MAX) {
                arr[tmp] = true;
                tmp += base;
            }
        }

        for (int i = 3; i <= MAX; i+=2) {
            if (!arr[i])
                pn.add(i);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        initPrimeNum();

        int n;
        while (( n = Integer.parseInt(br.readLine()) ) != 0) {
            Iterator<Integer> it = pn.iterator();
            int a = it.next();
            boolean chk = false;
            while (a < n) {
                if (pn.contains(n-a)) {
                    chk = true;
                    answer.append(n).append(' ').append('=')
                            .append(' ').append(a).append(' ').append('+')
                            .append(' ').append(n-a).append('\n');
                    break;
                }
                a = it.next();
            }
            if (!chk)
                answer.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
