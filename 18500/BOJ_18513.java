import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        Set<Integer> v = new HashSet<>();
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            v.add(cur);
            q.add(new int[]{cur, 0});
        }

        long sum = 0 ;
        while (k!=0 && !q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int dist = cur[1];
            if (!v.contains(idx-1)) {
                k--;
                v.add(idx-1);
                sum += dist+1;
                q.add(new int[] {idx-1, dist+1});
            }
            if (k==0) break;
            if (!v.contains(idx+1)) {
                k--;
                v.add(idx+1);
                sum += dist+1;
                q.add(new int[] {idx+1, dist+1});
            }
        }

        System.out.println(sum);
    }
}
