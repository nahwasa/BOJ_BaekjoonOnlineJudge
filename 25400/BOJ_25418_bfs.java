import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[k+1];
        q.add(new int[]{a,0});
        v[a] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == k) {
                System.out.println(cur[1]);
                return;
            }
            if (cur[0]*2<=k) {
                v[cur[0]*2] = true;
                q.add(new int[]{cur[0]*2, cur[1]+1});
            }
            if (!v[cur[0]+1])
                q.add(new int[]{cur[0]+1, cur[1]+1});
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
