import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    class S {
        String str;
        int cnt;
        public S(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    private static final String START = "12348765";
    private static final int[][] TRANSFORM_TYPE_RULE = {
            {4,5,6,7,0,1,2,3},
            {3,0,1,2,7,4,5,6},
            {0,2,6,3,4,1,5,7},
            {7,1,2,3,4,5,6,0}
    };
    private String transform(String str, int type) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) sb.append(str.charAt(TRANSFORM_TYPE_RULE[type][i]));
        return sb.toString();
    }
    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        char[] goal = new char[8];
        for (int i = 0; i < 4; i++) goal[i] = st.nextToken().charAt(0);
        for (int i = 7; i >= 4; i--) goal[i] = st.nextToken().charAt(0);
        HashSet<String> v = new HashSet<>();
        Queue<S> q = new ArrayDeque<>();
        final String GOAL = new String(goal);
        q.add(new S(START, 0));
        v.add(START);
        while (!q.isEmpty()) {
            String cur = q.peek().str;
            int cnt = q.poll().cnt;
            if (cur.equals(GOAL)) {
                System.out.println(cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                String next = transform(cur, i);
                if (v.contains(next)) continue;
                v.add(next);
                q.add(new S(next, cnt+1));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
