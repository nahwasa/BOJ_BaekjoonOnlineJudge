import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        int[] minimumPn = getMinimumPn(1000000);

        boolean[] arr = new boolean[minimumPn.length];
        int oddCnt = 0;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int a = Integer.parseInt(br.readLine());

            while (a!=1) {
                int pn = minimumPn[a];
                if (arr[pn] = !arr[pn]) oddCnt++;
                else oddCnt--;

                a/=pn;
            }
            sb.append(oddCnt==0?"DA":"NE").append('\n');
        }
        System.out.print(sb);
    }
}
