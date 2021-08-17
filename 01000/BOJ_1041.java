import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6+1];
        for (int i = 1; i <= 6; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int arrMin = Integer.MAX_VALUE;
        int arrMax = Integer.MIN_VALUE;
        int arrSum = 0;
        for (int i = 1; i <= 6; i++) {
            arrMin = Math.min(arrMin, arr[i]);
            arrMax = Math.max(arrMax, arr[i]);
            arrSum += arr[i];
        }

        if (n == 1) {   // 1개일 때 예외처리
            System.out.println(arrSum - arrMax);
            return;
        }

        int[] sum = new int[3+1];   //1:한면 가장 작은거, 2:연속된 2면중 가장 작은거, 3:8개의 모서리에 연결된 3면중 가장 작은거
        sum[1] = arrMin;
        sum[2] = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i == j || 7-i==j)   // 동일한거 제외, 서로 맡은편에 있는 주사위 수 제외
                    continue;
                sum[2] = Math.min(sum[2], arr[i] + arr[j]);
            }
        }
        sum[3] = Integer.MAX_VALUE;
        int[][] tmp = {
                {1,2,3}, {1,3,5}, {1,5,4}, {1,4,2},
                {6,2,4}, {6,4,5}, {6,2,3}, {6,5,3}
        };
        for (int i = 0; i < tmp.length; i++) {
            int tmpSum = 0;
            for (int j = 0; j < 3; j++)
                tmpSum += arr[tmp[i][j]];
            sum[3] = Math.min(sum[3], tmpSum);
        }

        long calc = 4 * sum[3];
        calc += 4 * (n-1) * sum[2];
        calc += 4 * (n-2) * sum[2];
        calc += (n-2) * (n-2) * sum[1];
        calc += 4 * (n-2) * (n-1) * sum[1];
        System.out.println(calc);
    }
}
