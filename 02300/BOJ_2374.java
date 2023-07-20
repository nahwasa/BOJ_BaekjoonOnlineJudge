import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int n;
    int[] arr;

    private void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }
        long answer = 0;
        answer += daq(max, 0, maxIdx-1);
        answer += daq(max, maxIdx+1, n-1);

        System.out.println(answer);
    }

    private long daq(final int limit, final int s, final int e) {
        int max = 0;
        int maxIdx = 0;

        if (s<0 || e<0 || s>=n || e>=n || s>e) return 0;

        for (int i = s; i <= e; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        long answer = limit-max;
        answer += daq(max, s, maxIdx-1);
        answer += daq(max, maxIdx+1, e);

        return answer;
    }
}
