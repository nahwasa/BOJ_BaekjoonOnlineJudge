import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < 3; i++) {
            sum += arr[i] = Integer.parseInt(st.nextToken());
            mul *= arr[i];
        }

        for (int i = 0; i < 3; i++) {
            if (sum == arr[i]*2) {
                System.out.println(1);
                return;
            }

            if (mul == arr[i]*arr[i]) {
                System.out.println(2);
                return;
            }
        }

        System.out.println(3);
    }
}
