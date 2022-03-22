import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private final static int MAX_NUM = 1000003;
    private TreeSet<Integer> findPn() {
        boolean[] pnChk = new boolean[MAX_NUM+1];
        for (int base = 3; base <= Math.sqrt(MAX_NUM); base+=2) {
            if (pnChk[base]) continue;
            int tmp = base+base;
            while (tmp <= MAX_NUM) {
                pnChk[tmp] = true;
                tmp+=base;
            }
        }

        TreeSet<Integer> pn = new TreeSet<>();
        pn.add(2);
        for (int i = 3; i <= MAX_NUM; i+=2) {
            if (!pnChk[i])
                pn.add(i);
        }
        return pn;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> pn = findPn();
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            while (st.hasMoreTokens()) {
                sum += pn.ceiling(Integer.parseInt(st.nextToken()));
            }
            answer.append(sum).append('\n');
        }
        System.out.print(answer);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
