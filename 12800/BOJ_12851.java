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

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(N, 0));
        boolean isEnd = false;
        int endCnt = 0;
        int goal = 0;

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int tmp = pos.n;
            int dist = pos.d;
            chk[tmp] = true;

            if (!isEnd && tmp == K) {
                isEnd = true;
                goal = dist;
            }

            if (isEnd && tmp == K && dist == goal) {
                endCnt++;
            }

            for (int i = 0; i < 3; i++) {
                int next = getNext(tmp, i);
                if (next<0 || next>MAX-1 || chk[next]) continue;
                q.add(new Pos(next, dist+1));
            }
        }
        System.out.println(goal + "\n" + endCnt);
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
class Pos {
    int n, d;
    public Pos(int n, int d) { this.n=n; this.d=d; }
}
