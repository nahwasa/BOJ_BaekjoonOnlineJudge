import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private static final char[] COLOR = new char[]{'R', 'G', 'B'};
    private int n;
    private List<Integer>[] edges;
    private int[][] arr;
    private int[][] dp;
    private boolean[] v;

    private void solution() throws Exception {
        // init
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];
        v = new boolean[n+1];
        edges = new List[n+1];
        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        arr = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        
        // find maximum answer
        int ans = 0;
        edges[0].add(1);
        for (int i = 0; i < 3; i++) ans = max(ans, find(0, i));
        
        
        // tracking color
        char[] selected = new char[n+1];
        Stack<int[]> stk = new Stack<>();
        for (int i = 0; i < 3; i++) {
            if (dp[0][i] == ans) {
                stk.push(new int[]{0, i});
                break;
            }
        }

        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int idx = cur[0];
            int color = cur[1];
            selected[idx] = COLOR[color];

            for (int next : edges[idx]) {
                if (v[next]) continue;
                v[next] = true;

                int nextColor = -1;
                int nextMax = 0;
                for (int i = 0; i < 3; i++) {
                    if (color == i) continue;

                    if (nextMax < dp[next][i]) {
                        nextMax = dp[next][i];
                        nextColor = i;
                    }
                }

                stk.push(new int[]{next, nextColor});
            }
        }

        
        // print answer
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append('\n');
        for (int i = 1; i <= n; i++) sb.append(selected[i]);
        System.out.println(sb);
    }

    private int find(final int idx, final int color) {
        if (dp[idx][color] != 0)
            return dp[idx][color];

        int sum = 0;

        for (int next : edges[idx]) {
            if (v[next]) continue;
            v[next] = true;

            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (color == i) continue;

                max = max(max, find(next, i));
            }
            sum += max;

            v[next] = false;
        }

        return dp[idx][color] = sum + arr[idx][color];
    }
}

class Stack<T> {
    private final Deque<T> dq = new ArrayDeque<>();
    boolean isEmpty(){return dq.isEmpty();}
    T pop() {return dq.pollFirst();}
    void push(T e) {dq.addFirst(e);}
}
