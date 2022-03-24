import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int evenSum = 0;
        int oddSum = 0;
        int minOdd = Integer.MAX_VALUE;
        int oddCnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            if ((cur&1)==0) {
                evenSum+=cur;
                continue;
            }
            oddCnt++;
            oddSum+=cur;
            if (cur<minOdd) minOdd=cur;
        }
        if ((oddCnt&1)==1) oddSum-=minOdd;
        if (oddCnt == 1 && evenSum == 0) {
            System.out.println("NIESTETY");
            return;
        }
        System.out.println(evenSum+oddSum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
