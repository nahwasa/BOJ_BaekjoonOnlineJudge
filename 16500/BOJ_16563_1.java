import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private int[] getMinimumPn(int limit) {
        int[] arr = new int[limit+1];
        for (int i = 2; i <= limit; i++) {
            if (arr[i] != 0) continue;

            int base = i;
            while(base <= limit) {
                if (arr[base] == 0)
                    arr[base] = i;
                base += i;
            }
        }
        return arr;
    }

    public void solution() throws Exception {
        int[] minimumPn = getMinimumPn(5000000);

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            while (cur!=1) {
                sb.append(minimumPn[cur]).append(' ');
                cur /= minimumPn[cur];
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
