import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    int r, c, parkingIdx;
    int[][] map;
    boolean[][] blockMap;
    ArrayList<int[]> cars;
    ArrayList<int[]>[] edges;
    ArrayList<Integer> distancePoint;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        init();
        if (cars.isEmpty()) {
            System.out.println(0);
            return;
        }
        if (cars.size() > parkingIdx) {
            System.out.println(-1);
            return;
        }

        makeWeightedEdges();
        makeDistinctDistancePoint();
        int answer = getMinParkingTime();
        System.out.println(answer);
    }

    private void init() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        blockMap = new boolean[r][c];
        for (int[] row : map)
            Arrays.fill(row, -1);

        cars = new ArrayList<>();
        parkingIdx = 0;
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                switch (row.charAt(j)) {
                    case 'C': cars.add(new int[]{i, j}); break;
                    case 'P': map[i][j] = parkingIdx++; break;
                    case 'X': blockMap[i][j] = true; break;
                }
            }
        }
    }

    private void makeWeightedEdges() {
        edges = new ArrayList[cars.size()];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new ArrayList<>();

        for (int carIdx = 0; carIdx < cars.size(); carIdx++) {
            int[] car = cars.get(carIdx);
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] v = new boolean[r][c];
            q.add(new int[]{car[0], car[1], 0});
            v[car[0]][car[1]] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cr = cur[0];
                int cc = cur[1];
                int dist = cur[2];

                for (int d = 0; d < 4; d++) {
                    int nr = cr + DR[d];
                    int nc = cc + DC[d];
                    int nDist = dist+1;
                    if (nr<0||nr>=r||nc<0||nc>=c||v[nr][nc]||blockMap[nr][nc])
                        continue;
                    if (map[nr][nc]!=-1)
                        edges[carIdx].add(new int[]{map[nr][nc], nDist});

                    v[nr][nc] = true;
                    q.add(new int[]{nr, nc, nDist});
                }
            }
        }
    }

    private void makeDistinctDistancePoint() {
        Set<Integer> set = new HashSet<>();
        distancePoint = new ArrayList<>();
        for (ArrayList<int[]> cars: edges) {
            for (int[] car: cars) {
                if (set.contains(car[1])) continue;
                set.add(car[1]);
                distancePoint.add(car[1]);
            }
        }
        Collections.sort(distancePoint);
    }

    private int getMinParkingTime() {
        for (int limit: distancePoint) {
            int[] matched = new int[parkingIdx];
            Arrays.fill(matched, -1);
            boolean valid = true;

            for (int i = 0; i < cars.size() && valid; i++) {
                boolean[] v = new boolean[parkingIdx];
                if (!matching(i, limit, v, matched)) {
                    valid = false;
                }
            }

            if (valid)
                return limit;
        }

        return -1;
    }

    private boolean matching(int car, int limit, boolean[] v, int[] matched) {
        for (int[] edge : edges[car]) {
            int next = edge[0];

            if (v[next] || edge[1] > limit) continue;
            v[next] = true;
            if (matched[next] == -1 || matching(matched[next], limit, v, matched)) {
                matched[next] = car;
                return true;
            }
        }
        return false;
    }
}
