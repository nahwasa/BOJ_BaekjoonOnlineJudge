import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = tmp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());

        if (isSame(a, b)) {
            System.out.println(1);
            return;
        }
        
        Arrays.sort(tmp);
        int len = n;
        for (int i = n-1; i >= 0; i--) {
            if (b[i] != tmp[i]) break;
            for (int j = 0; j < len-1; j++) {
                if (a[j] > a[j+1]) {
                    int swap = a[j];
                    a[j] = a[j+1];
                    a[j+1] = swap;
                    if (a[len-1] == b[len-1] && isSame(a, b)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
            len--;
        }
        if (isSame(a, b)) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < n-1; i++) {
            if (a[i] > a[i+1]) {
                int swap = a[i];
                a[i] = a[i+1];
                a[i+1] = swap;
                if (isSame(a, b)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
