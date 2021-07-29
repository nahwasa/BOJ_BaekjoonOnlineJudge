import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int MAX = 1000000;

    private static long[] makeSolutionArr() {
        long[] arr = new long[MAX+1];

        // make f(x)
        Arrays.fill(arr, 1);
        for (int i = 2; i <= MAX; i++) {
            int base = 1;
            while (i*base <= MAX) {
                arr[i*base] += (long)i;
                base++;
            }
        }

        // make g(x)
        for (int i = 2; i <= MAX; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] solution = makeSolutionArr();
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solution[n]).append('\n');
        }
        System.out.println(sb);
    }
}
