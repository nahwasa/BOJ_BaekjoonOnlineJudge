import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int getArithmeticSequenceSum(int s, int e, int k) {
        return (s+e)*k/2;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int prevSum = getArithmeticSequenceSum(1,k,k);
        if (n<prevSum) {
            System.out.println(-1);
            return;
        }
        int i = 2;
        while (true) {
            int curSum = getArithmeticSequenceSum(i,k+i-1, k);
            if (curSum>n) {
                if (prevSum == n)
                    System.out.println(k-1);
                else
                    System.out.println(k);
                return;
            }
            prevSum = curSum;
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
