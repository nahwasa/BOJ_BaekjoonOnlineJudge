import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

interface Move {
    int nextPosition(int cur);
}

class PlusMove implements Move {
    @Override
    public int nextPosition(int cur) {
        return cur+1;
    }
}

class MinusMove implements Move {
    @Override
    public int nextPosition(int cur) {
        return cur-1;
    }
}

class MultipleMove implements Move {
    @Override
    public int nextPosition(int cur) {
        return cur*2;
    }
}

enum Config {
    LIMIT(500000);
    private int config;
    private Config(int config) {
        this.config = config;
    }
    int getValue() {
        return this.config;
    }
}

class SiblingPosition {
    ArrayList<Integer> POSITION = new ArrayList<>();
    public SiblingPosition(int k) {
        int weight = 0;
        while ((k += weight++)<=Config.LIMIT.getValue())
            POSITION.add(k);
    }
    int getMovedLocation(int dist) {
        return POSITION.get(dist);
    }
    int size() {
        return POSITION.size();
    }
}

class Position {
    int n, dist;
    public Position(int n, int dist) {
        this.n = n;
        this.dist = dist;
    }
    public boolean isValidPosition() {
        return this.n>=0 && this.n<=Config.LIMIT.getValue();
    }
    public boolean checkMeet(SiblingPosition siblingPosition) {
        return this.n == siblingPosition.getMovedLocation(this.dist);
    }
}

public class Main {
    private final Move[] MOVEMENTS = {new MinusMove(), new PlusMove(), new MultipleMove()};
    private SiblingPosition siblingPosition;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        siblingPosition = new SiblingPosition(K);

        Queue<Position> q = new ArrayDeque<>();
        int[][] v = new int[Config.LIMIT.getValue()+1][2];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++)
                v[i][j] = Integer.MAX_VALUE;
        }
        q.add(new Position(N, 0));
        v[N][0] = 0;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (Move movement : MOVEMENTS) {
                int nextN = movement.nextPosition(cur.n);
                Position next = new Position(nextN, cur.dist+1);
                if (!next.isValidPosition() || v[nextN][next.dist%2]<=next.dist || next.dist >= siblingPosition.size())
                    continue;
                v[nextN][next.dist%2] = next.dist;
                q.add(next);
            }
        }

        for (int i = 0; i < siblingPosition.size(); i++) {
            int cur = siblingPosition.getMovedLocation(i);
            if (v[cur][i%2] > i) continue;
            if (min>i) {
                min = i;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
