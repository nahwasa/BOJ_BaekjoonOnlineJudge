import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, sqrtN;
    int[] bucket, cnt;

    private void add(int num) {
        cnt[num]++;
        bucket[num/sqrtN]++;
    }

    private int getAnswer(int num) {
        int totalCnt = 0;
        while (num%sqrtN != 0 && num!=n+1)
            totalCnt += cnt[num++];
        if (num != n+1) {
            for (int i = num/sqrtN; i < bucket.length; i++) {
                totalCnt += bucket[i];
            }
        }
        return totalCnt;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sqrtN = Math.max(1, (int)Math.sqrt(n));
        bucket = new int[n/sqrtN+1];
        cnt = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            answer += getAnswer(num);
            add(num);
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
