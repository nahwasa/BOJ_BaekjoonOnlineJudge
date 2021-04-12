import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] base = new int[n];
        int[] arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < n; i++) {
            base[i] = Integer.parseInt(st1.nextToken());
            arr[i] = Integer.parseInt(st2.nextToken());
            if (arr[i] == base[0])  idx = i;
        }
        st1 = null; st2 = null;
        System.gc();
        boolean isValid1 = true;
        boolean isValid2 = true;
        for (int i = 0; i < n; i++) {
            int ti1 = (i + idx) % n;
            int ti2 = (idx - i + n) % n;
            if (base[i] != arr[ti1])    isValid1 = false;
            if (base[i] != arr[ti2])    isValid2 = false;
        }
        System.out.println(isValid1 || isValid2 ? "good puzzle" : "bad puzzle");
    }
}
