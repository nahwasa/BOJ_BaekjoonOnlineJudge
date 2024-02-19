import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int LIMIT_OF_INPUT = 1000000;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        List<int[]> amicablePair = initAmicablePairs();

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            sb.append('\n').append("Amicable numbers between 1 and ").append(n).append('\n');
            int cnt = 0;
            for (int[] cur : amicablePair) {
                if (cur[1] <= n) {
                    sb.append(cur[0]).append(' ').append(cur[1]).append('\n');
                    cnt++;
                }
            }
            if (cnt == 0) {
                sb.append("None\n");
            }

        }

        System.out.print(sb);
    }

    private List<int[]> initAmicablePairs() {
        List<int[]> amicablePair = new ArrayList<>();
        Set<Integer> alreadyChecked = new HashSet<>();

        for (int i = 2; i <= LIMIT_OF_INPUT; i++) {
            if (alreadyChecked.contains(i)) continue;

            int a = sumOfDivisors(i);
            if (i >= a || a > LIMIT_OF_INPUT) continue;

            if (sumOfDivisors(a) == i) {
                amicablePair.add(new int[]{i, a});
                alreadyChecked.add(a);
            }
        }
        return amicablePair;
    }

    public int sumOfDivisors(int n) {
        int limit = (int) Math.sqrt(n);
        int sum = 1;
        for (int i = 2; i <= limit; i++) {
            if (n%i==0) sum += i + (n/i);
        }
        if (limit * limit == n) sum-=limit;
        return sum;
    }
}
