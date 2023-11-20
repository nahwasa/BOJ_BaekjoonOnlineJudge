import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[20001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[(arr[i] = Integer.parseInt(st.nextToken()))+10000]++;
        }

        long answer = 0l;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = arr[i]+arr[j];
                if (Math.abs(sum) > 10000) continue;
                
                answer += cnt[-sum+10000];
                if (-sum==arr[i]) answer--;
                if (-sum==arr[j]) answer--;
            }
        }

        System.out.println(answer/3);
    }
}
