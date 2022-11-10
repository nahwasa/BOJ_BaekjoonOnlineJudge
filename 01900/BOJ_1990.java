import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private ArrayList<Integer> getPn(int limit) {
        ArrayList<Integer> pn = new ArrayList<>();
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
    
    private boolean isPalindrome(int num) {
        int base = 1;
        int len = 0;
        while (num >= base) {
            base *= 10;
            len++;
        }
        int low = 10;
        int high = base/10;
        for (int i = 0; i < len/2; i++, low*=10, high/=10)
            if ((num%low)/(low/10) != (num/high)%10) return false;
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> pn = getPn(b);
        for (int cur : pn) {
            if (cur < a) continue;
            if (isPalindrome(cur))
                sb.append(cur).append('\n');
        }
        sb.append(-1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
