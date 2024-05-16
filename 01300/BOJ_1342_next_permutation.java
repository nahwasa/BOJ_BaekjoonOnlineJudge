import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        int ans = 0;
        do {
            boolean chk = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i-1]) {
                    chk = false;
                    break;
                }
            }
            if (chk) ans++;
        } while (nextPermutation(arr));
        System.out.println(ans);
    }

    boolean nextPermutation(char[] arr) {
        for (int a = arr.length - 2; a >= 0; --a) {
            if (arr[a] < arr[a + 1]) {
                for (int b = arr.length - 1; ; --b) {
                    if (arr[b] > arr[a]) {
                        char t = arr[a];
                        arr[a] = arr[b];
                        arr[b] = t;
                        for (++a, b = arr.length - 1; a < b; ++a, --b) {
                            t = arr[a];
                            arr[a] = arr[b];
                            arr[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
