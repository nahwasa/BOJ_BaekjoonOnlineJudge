import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int ARR_SIZE = 'Z'-'A'+1;
    private static int atoi(char c) { return c - 'A'; }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        int[] base = new int[ARR_SIZE];
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++)  base[atoi(str.charAt(i))]++;
        int res = 0;
        while (n-->0) {
            int[] target = new int[ARR_SIZE];
            str = br.readLine();
            for (int i = 0; i < str.length(); i++)  target[atoi(str.charAt(i))]++;
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < ARR_SIZE; i++) {
                int tmp = base[i] - target[i];
                if (tmp > 0)    sum1+=tmp;
                else    sum2+=tmp;
            }
            if (Math.abs(sum1) >= 2 || Math.abs(sum2) >= 2)  continue;
            res++;
        }
        System.out.println(res);
    }
}
