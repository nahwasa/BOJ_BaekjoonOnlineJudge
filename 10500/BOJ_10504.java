import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int SEQ_SUM_LIMIT = 44720;
    private static final int[] sumOfSeq = new int[SEQ_SUM_LIMIT+1];

    private int getAnswer(int n) {
        for (int i = 2; i <= SEQ_SUM_LIMIT; i++) {
            int tmp = n - sumOfSeq[i];
            if (tmp < 0) return -1;
            if (tmp%i==0) return i;
        }
        return -1;
    }
    private void solution() throws Exception {
        for (int i = 1; i <= SEQ_SUM_LIMIT; i++) sumOfSeq[i] = sumOfSeq[i-1]+i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            int answer = getAnswer(n);
            if (answer == -1) {
                sb.append("IMPOSSIBLE").append('\n');
                continue;
            }
            sb.append(n).append(' ').append('=').append(' ');
            int base = (n-sumOfSeq[answer])/answer;
            for (int i = 1; i < answer; i++)
                sb.append(base+i).append(' ').append('+').append(' ');
            sb.append(base+answer).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
