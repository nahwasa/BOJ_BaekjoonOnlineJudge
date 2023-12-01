import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int LEN = 45;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int[] t = new int[LEN];
        for (int i = 1; i < LEN; i++) t[i] = i*(i+1)/2;

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(possible(t, n) ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }

    private boolean possible(final int[] t, final int n) {
        for (int i = 1; i < LEN; i++)
            for (int j = i; j < LEN; j++)
                for (int k = j; k < LEN; k++)
                    if (t[i]+t[j]+t[k] == n)
                        return true;
        return false;
    }

}
