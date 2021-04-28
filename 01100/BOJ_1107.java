import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];
        Arrays.fill(arr, true);
        if (m!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (m-->0)   arr[Integer.parseInt(st.nextToken())] = false;
        }
        int min = Math.abs(100-n);
        for (int i = 0; i <= 1000001; i++) {
            if (!can(arr, i))    continue;
            min = Math.min(min, Math.abs(i-n)+intLen(i));
        }
        System.out.println(min);
    }
    private static int intLen(int num) {
        int base = 1;
        for (int i = 0; i <= 6; i++) {
            base *= 10;
            if (num < base) return i+1;
        }
        return -1;
    }
    private static boolean can(boolean[] arr, int num) {
        int len = intLen(num);
        while (len-->0) {
            if (!arr[num%10]) return false;
            num/=10;
        }
        return true;
    }
}
