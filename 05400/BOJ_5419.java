import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Island implements Comparable<Island> {
    int x, y;
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Island o) {
        if (this.x == o.x)
            return o.y - this.y;
        return this.x - o.x;
    }
}

public class Main {
    PriorityQueue<Island> pq;
    HashSet<Integer> yChk;
    PriorityQueue<Integer> yPq;
    HashMap<Integer, Integer> comp;
    int compSize, sqrtN;
    int[] bucket, cnt;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void init() {
        pq = new PriorityQueue<>();
        yChk = new HashSet<>();
        yPq = new PriorityQueue<>();
        comp = new HashMap<>();
    }

    private void initIsland() throws Exception {
        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Island(x, y));
            if (!yChk.contains(y)) {
                yChk.add(y);
                yPq.add(y);
            }
        }
    }

    private void compressionY() {
        int compNum = 0;
        while (!yPq.isEmpty()) {
            comp.put(yPq.poll(), compNum++);
        }
        compSize = compNum;
    }

    private long getOverCnt(int y) {
        long totalCnt = 0;
        while (y%sqrtN != 0 && y!=compSize)
            totalCnt += cnt[y++];
        if (y != compSize) {
            for (int i = y / sqrtN; i < bucket.length; i++) {
                totalCnt += bucket[i];
            }
        }
        return totalCnt;
    }

    private void add(int y) {
        cnt[y]++;
        bucket[y/sqrtN]++;
    }

    private long getAnswer() {
        sqrtN = (int)Math.sqrt(compSize);
        if (sqrtN == 0) sqrtN = 1;
        bucket = new int[compSize/sqrtN+1];
        cnt = new int[compSize];

        long sum = 0;
        while (!pq.isEmpty()) {
            Island cur = pq.poll();
            sum += getOverCnt(comp.get(cur.y));
            add(comp.get(cur.y));
        }
        return sum;
    }

    private void solution() throws Exception {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            init();
            initIsland();
            compressionY();
            sb.append(getAnswer()).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
