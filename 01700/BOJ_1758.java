import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        while (n-->0)   arr[n] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i]-i;
            if (tmp <= 0) break;
            sum += tmp;
        }
        System.out.println(sum);
    }
}
