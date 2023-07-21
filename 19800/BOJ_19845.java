import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, n+1);

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (tm.containsKey(arr[i])) continue;
            tm.put(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (c > arr[r]) {
                sb.append(0).append('\n');
                continue;
            }

            sb.append(arr[r]-c+1+tm.lowerEntry(c).getValue()-1-r).append('\n');
        }

        System.out.print(sb);
    }
}
