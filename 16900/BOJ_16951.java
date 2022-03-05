import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 1; i <= 1000; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i+j*k)
                    cnt++;
            }
            if (cnt>max) max = cnt;
        }
        System.out.println(n - max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
