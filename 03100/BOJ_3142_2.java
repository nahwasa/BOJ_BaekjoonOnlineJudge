import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private List<Integer> getPn(int limit) {
        List<Integer> pn = new ArrayList<>();
        boolean[] isPn = new boolean[limit+1];
        int sqrtN = (int)Math.sqrt(limit);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= limit) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= limit; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
        return pn;
    }

    public void solution() throws Exception {
        List<Integer> pn = getPn(1000000);
        Map<Integer, Integer> pnMap = new HashMap<>();
        for (int i = 0; i < pn.size(); i++) pnMap.put(pn.get(i), i);

        boolean[] arr = new boolean[pn.size()];
        int oddCnt = 0;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int a = Integer.parseInt(br.readLine());
            int idx = 0;
            int curPn = pn.get(idx);
            while (curPn <= Math.sqrt(a)) {
                while (a % curPn == 0) {
                    a /= curPn;
                    if (arr[idx] = !arr[idx]) oddCnt++;
                    else oddCnt--;
                }
                curPn = pn.get(++idx);
            }
            if (pnMap.containsKey(a)) {
                idx = pnMap.get(a);
                if (arr[idx] = !arr[idx]) oddCnt++;
                else oddCnt--;
            }
            sb.append(oddCnt==0?"DA":"NE").append('\n');
        }
        System.out.print(sb);
    }
}
