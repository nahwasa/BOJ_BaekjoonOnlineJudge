import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public String bfs(long s, long t) {
        Set<Long> v = new HashSet<>();
        v.add(s);
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(s, '\0', null));
        boolean divideChk = false;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.num == t) {
                StringBuilder sb = new StringBuilder();
                while (cur.bf != null) {
                    sb.append(cur.c);
                    cur = cur.bf;
                }
                return sb.reverse().toString();
            }

            long next = 1l*cur.num*cur.num;
            if (next <= t && !v.contains(next)) {
                v.add(next);
                q.add(new Node(next, '*', cur));
            }

            next = 2*cur.num;
            if (next <= t && !v.contains(next)) {
                v.add(next);
                q.add(new Node(next, '+', cur));
            }

            if (divideChk) continue;
            divideChk = true;
            next = 1;
            if (v.contains(next)) continue;
            v.add(next);
            q.add(new Node(next, '/', cur));
        }

        return "-1";
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        if (s == t) {
            System.out.println(0);
            return;
        }
        if (t == 1) {
            System.out.println("/");
            return;
        }

        System.out.println(bfs(s, t));
    }
}

class Node {
    long num;
    char c;
    Node bf;
    public Node(long num, char c, Node bf) {
        this.num = num;
        this.c = c;
        this.bf = bf;
    }
}
