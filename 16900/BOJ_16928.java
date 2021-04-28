import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            hm.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] dist = new int[101];
        boolean[] v = new boolean[101];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) {
                System.out.println(dist[100]);
                return;
            }
            for (int i = 6; i >= 1; i--) {
                int next = cur + i;
                next = hm.getOrDefault(next, next);
                if (next > 100 || v[next])  continue;
                v[next] = true;
                dist[next] = dist[next]==0?dist[cur]+1:dist[next];
                q.add(next);
            }
        }
    }
}
