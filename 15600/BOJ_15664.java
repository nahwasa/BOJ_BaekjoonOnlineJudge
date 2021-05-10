import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // input buffer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve("", m, 0, -1, arr);
    }

    static HashSet<String> hs = new HashSet<>();
    private static void solve(String s, int m, int cnt, int curIdx, int[] arr) {
        if (cnt == m) {
            if (hs.contains(s)) return;
            hs.add(s);
            System.out.println(s);
            return;
        }
        for (int i = curIdx+1; i < arr.length; i++) {
            solve(s + arr[i] + " ", m, cnt+1, i, arr);
        }
    }
}
