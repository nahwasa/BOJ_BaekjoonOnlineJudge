import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        new Main().solution(n, k, str);
    }

    public void solution(int n, int k, String str) throws Exception {
        long[] base = new long[2*n-1];
        base[0] = 1;
        for (int i = 1; i < n; i++) {
            base[i] = base[i-1] + i;
        }
        base[2*n-2] = 1l*n*n;
        for (int i = 2; i < n; i++) {
            base[2*n-1-i] = base[2*n-i] - i;
        }

        int r = 0;
        int c = 0;
        long sum = 1;
        for (int i = 0; i < k; i++) {
            switch (str.charAt(i)) {
                case 'U': r--; break;
                case 'D': r++; break;
                case 'L': c--; break;
                case 'R': c++; break;
            }
            sum += base[r+c] + getWeight(n, r, c);
        }
        System.out.println(sum);
    }

    private int getWeight(int n, int r, int c) {
        if (r+c >= n) {
            r = n-1-r;
            c = n-1-c;
            int tmp = r;
            r = c;
            c = tmp;
        }
        return (r+c)%2==0 ? c : r;
    }
}
