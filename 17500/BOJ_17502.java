import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            char cur = 'a';
            if (arr[i] != '?') cur = arr[i];
            if (arr[n-i-1] != '?') cur = arr[n-i-1];
            arr[i] = arr[n-i-1] = cur;
        }
        System.out.println(String.valueOf(arr));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
