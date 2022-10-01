import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int getAnswer(int s, int t) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s,t,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curS = cur[0];
            int curT = cur[1];
            int ith = cur[2];
            if (curS == curT) {
                return ith;
            }
            if (curS > curT)
                continue;
            q.add(new int[]{curS*2, curT+3, ith+1});
            q.add(new int[]{curS+1, curT, ith+1});
        }
        return -1;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (c-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            sb.append(getAnswer(s, t)).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
