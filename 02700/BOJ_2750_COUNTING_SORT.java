import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] counting = new int[2001];
        for (int i = 0; i < n; i++) {
            counting[Integer.parseInt(br.readLine())+1000]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2001; i++) {
            if (counting[i] == 0) continue;
            sb.append(i-1000).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
