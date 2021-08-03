import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final String Y = "YES";
    private static final String N = "NO";
    private static StringTokenizer st;

    private static int nextInt() { return Integer.parseInt(st.nextToken()); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();

        boolean isInc = true;
        for (int i = 1; i < n; i++) {
            int a = arr[i-1];
            int b = arr[i];
            if (a == b) {
                System.out.println(N);
                return;
            }
            if (isInc && a>b)   isInc = false;
            if (!isInc && a<b) {
                System.out.println(N);
                return;
            }
        }
        System.out.println(Y);
    }
}
