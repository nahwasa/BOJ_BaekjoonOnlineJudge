import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        TreeSet<Integer> ts = new TreeSet<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            hs.put(arr[i], ++cnt);
            ts.add(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            Integer a = Integer.parseInt(st.nextToken());
            Integer b = Integer.parseInt(st.nextToken());
            a = ts.lower(a);
            b = ts.floor(b);
            a = a==null? 0 : hs.get(a);
            b = b==null? 0 : hs.get(b);
            sb.append(b-a).append('\n');
        }
        System.out.print(sb);
    }
}
