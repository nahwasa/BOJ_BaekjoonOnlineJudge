import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int MAX = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] chk = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] path = new int[MAX];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        chk[N] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tmp == K) {
                List<Integer> ll = new LinkedList<>();
                int pos = tmp;
                while (pos != N) {
                    ll.add(pos);
                    pos = path[pos];
                }
                ll.add(N);
                ListIterator<Integer> it = ll.listIterator(ll.size());
                StringBuilder sb = new StringBuilder();
                sb.append(dist[K]).append("\n");
                while (it.hasPrevious()) {
                    sb.append(it.previous()).append(" ");
                }
                System.out.println(sb);
                return;
            }
            for (int i = 0; i < 3; i++) {
                int next = getNext(tmp, i);
                if (next<0 || next>MAX-1 || chk[next]) continue;
                chk[next] = true;
                path[next] = tmp;
                dist[next] = dist[tmp]+1;
                q.add(next);
            }
        }
        br.close();
    }
    private static int getNext(int n, int type) {
        switch (type) {
            case 0 : return n-1;
            case 1 : return n+1;
            case 2 : return n*2;
        }
        return -1;
    }
}
