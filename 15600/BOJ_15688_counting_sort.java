import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int LIMIT = 1000000;
    StringBuilder sb = new StringBuilder();
    private void print(int n, int cnt) { while(cnt-->0) sb.append(n).append('\n'); }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[LIMIT*2+1];
        while (n-->0) arr[Integer.parseInt(br.readLine())+LIMIT]++;
        for (int i = 0; i <= LIMIT*2; i++) print(i-LIMIT, arr[i]);
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
