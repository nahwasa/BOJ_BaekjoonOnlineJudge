import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final static int[] dr = {2,2,3,3,-2,-2,-3,-3};
    private final static int[] dc = {-3,3,-2,2,-3,3,-2,2};

    private boolean chk(ArrayList<Integer> end, int cr, int cc, int d) {
        int er = end.get(0);
        int ec = end.get(1);
        switch (d) {
            case 0 : case 4 : if (cr==er && cc-1==ec) return true; break;
            case 1 : case 5 : if (cr==er && cc+1==ec) return true; break;
            case 2 : case 3 : if (cr+1==er && cc==ec) return true; break;
            case 6 : case 7 : if (cr-1==er && cc==ec) return true; break;
        }
        if (cr+dr[d]+(dr[d]<0?1:-1) == er && cc+dc[d]+(dc[d]<0?1:-1) == ec) return true;
        return false;
    }

    private int bfs(ArrayList<Integer> start, ArrayList<Integer> end) {
        int[][] dist = new int[10][9];
        for (int i = 0; i < dist.length; i++)
            Arrays.fill(dist[i], -1);

        Queue<ArrayList<Integer>> q = new ArrayDeque<>();
        q.add(start);
        dist[start.get(0)][start.get(1)] = 0;
        while (!q.isEmpty()) {
            int cr = q.peek().get(0);
            int cc = q.poll().get(1);
            if (end.get(0) == cr && end.get(1) == cc) {
                return dist[cr][cc];
            }
            for (int d = 0; d < 8; d++) {
                int nr = cr+dr[d];
                int nc = cc+dc[d];
                if (nr<0||nr>=10||nc<0||nc>=9||dist[nr][nc]!=-1||chk(end, cr, cc, d)) continue;
                ArrayList<Integer> next = new ArrayList<>();
                next.add(nr);
                next.add(nc);
                dist[nr][nc] = dist[cr][cc]+1;
                q.add(next);
            }
        }

        return -1;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> start = new ArrayList<>(2);
        start.add(Integer.parseInt(st.nextToken()));
        start.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> end = new ArrayList<>(2);
        end.add(Integer.parseInt(st.nextToken()));
        end.add(Integer.parseInt(st.nextToken()));

        System.out.println(bfs(start, end));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
