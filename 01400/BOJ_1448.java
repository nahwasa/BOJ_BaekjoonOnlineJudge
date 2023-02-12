import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        while (n-->0) arr[n] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i = arr.length-3; i >= 0; i--) {
            if (arr[i] + arr[i+1] > arr[i+2]) {
                System.out.println(arr[i] + arr[i+1] + arr[i+2]);
                return;
            }
        }
        System.out.println(-1);
    }
}
