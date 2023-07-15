import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) sb.append(d*arr[i]/sum).append('\n');

        System.out.print(sb);
    }
}
