import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static final int LIMIT = 104729;
    ArrayList<Integer> pn = new ArrayList<>();

    private void initPn() {
        boolean[] isPn = new boolean[LIMIT+1];
        int sqrtN = (int)Math.sqrt(LIMIT);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= LIMIT) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= LIMIT; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initPn();
        System.out.println(pn.get(Integer.parseInt(br.readLine())-1));
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
