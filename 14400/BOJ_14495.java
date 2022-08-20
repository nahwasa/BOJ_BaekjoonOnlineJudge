import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private final static int LIMIT = 116;

    private long[] getFiboLikeSomething() {
        long[] arr = new long[LIMIT+1];
        arr[1] = arr[2] = arr[3] = 1;
        for (int i = 4; i <= LIMIT; i++) {
            arr[i] = arr[i-1] + arr[i-3];
        }
        return arr;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getFiboLikeSomething()[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
