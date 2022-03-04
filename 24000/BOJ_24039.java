import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static final int MAX = 103;

    private int getAnswer(int n) {
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

        for (int i = 1; i < pn.size(); i++) {
            if (pn.get(i) * pn.get(i-1) > n) {
                return pn.get(i) * pn.get(i-1);
            }
        }
        return -1;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(getAnswer(Integer.parseInt(br.readLine())));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
