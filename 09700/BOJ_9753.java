import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    private static final int MAX = 51111;
    TreeSet<Integer> pnMult;

    private void initPrimeNum() {
        pnMult = new TreeSet<>();
        ArrayList<Integer> pn = new ArrayList<>();
        pn.add(2);

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

        for (int i = 0; i < pn.size()-1; i++) {
            for (int j = i+1; j < pn.size(); j++) {
                int mult = pn.get(i) * pn.get(j);
                if (mult >= 100000) break;
                pnMult.add(mult);
            }
        }
        pnMult.add(100001);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initPrimeNum();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            sb.append(pnMult.ceiling(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
