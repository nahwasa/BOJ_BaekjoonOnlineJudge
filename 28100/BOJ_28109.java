import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            int c = atoi(s[i]);
            if (k-c<=0) {
                s[i] = (char)('A'+k-1);
                System.out.println(s);
                return;
            }

            k-=c;
        }

        if (k == 1) {
            System.out.println(s);
            return;
        }
        k--;

        for (int i = n-1; i >= 0; i--) {
            int c = 'Z'-'A'-atoi(s[i]);
            if (k-c<=0) {
                s[i] = (char)(s[i]+k);
                System.out.println(s);
                return;
            }

            k-=c;
        }

        System.out.println(-1);
    }

    private int atoi(char c) {
        return c - 'A';
    }
}
