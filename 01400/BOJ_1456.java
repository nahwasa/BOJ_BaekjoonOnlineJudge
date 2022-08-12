import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private ArrayList<Integer> getPn(int LIMIT) {
        ArrayList<Integer> pn = new ArrayList<>();
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
        return pn;
    }

    private int getLength(long num) {
        int cnt = 0;
        while (num!=0) {
            cnt++;
            num/=10;
        }
        return cnt;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        ArrayList<Integer> pn = getPn((int)Math.sqrt(b));
        int cnt = 0;
        for (int i = 0; i < pn.size(); i++) {
            long cur = pn.get(i);
            int curCnt = getLength(cur);
            long tmp = cur;
            while ((tmp*=cur)<=b) {
                if (a<=tmp)
                    cnt++;
                int tmpCnt = getLength(tmp);
                if (curCnt + tmpCnt > 15)
                    break;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
