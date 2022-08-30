import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<17);
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        int answer = 0;
        while (k-->0) {
            int base = Integer.parseInt(br.readLine());
            int cur = 0;
            while ((cur+=base) <= n) arr[cur]=!arr[cur];
            int cnt = 0;
            for (int i = 1; i <= n; i++) if (!arr[i]) cnt++;
            if (answer<cnt) answer=cnt;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
