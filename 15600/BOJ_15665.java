import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int m;
    static HashSet<String> hs = new HashSet<>();
    static StringBuilder resSb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // input buffer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        solve(new LinkedList<Integer>() {
            @Override
            public String toString() {
                Iterator<Integer> it = this.iterator();
                StringBuilder sb = new StringBuilder();
                while (it.hasNext())
                    sb.append(it.next()).append(' ');
                return sb.toString();
            }
        });
        System.out.println(resSb);
    }
    private static void solve(LinkedList<Integer> res) {
        if (res.size() == m) {
            String str = res.toString();
            if (hs.contains(str)) return;
            hs.add(str);
            resSb.append(str).append('\n');
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
            solve(res);
            res.pollLast();
        }
    }
}
