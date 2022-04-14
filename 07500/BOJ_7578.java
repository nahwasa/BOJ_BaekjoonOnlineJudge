import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    int n, sqrtN;
    int[] bucket;
    boolean[] chk;

    private int getAnswer(int idx) {
        int cnt = 0;
        while (idx<n && idx%sqrtN!=0) {
            if (chk[idx])
                cnt++;
            idx++;
        }
        if (idx != n) {
            for (int i = idx/sqrtN; i < bucket.length; i++) {
                cnt += bucket[i];
            }
        }
        return cnt;
    }

    private void add(int idx) {
        chk[idx] = true;
        bucket[idx/sqrtN]++;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(Integer.parseInt(st.nextToken()), i);
        }
        sqrtN = (int)Math.sqrt(n);
        bucket = new int[n/sqrtN+1];
        chk = new boolean[n];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = hm.get(Integer.parseInt(st.nextToken()));
            sum += getAnswer(cur);
            add(cur);
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
