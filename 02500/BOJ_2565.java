import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int N = n;
        int[] arr = new int[501];
        boolean[] v = new boolean[501];
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            v[a] = true;
            arr[a] = Integer.parseInt(st.nextToken());
        }
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        for (int i = 0; i < arr.length; i++) {
            if (!v[i])
                continue;
            int cur = arr[i];
            if (ts.last() > cur)
                ts.remove((ts.ceiling(cur)));
            ts.add(cur);
        }
        System.out.println(N - ts.size() + 1);
    }
}
