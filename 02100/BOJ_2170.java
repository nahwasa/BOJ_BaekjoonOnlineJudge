import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    class Line implements Comparable<Line> {
        int x, y;
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Line o) {
            if (this.x == o.x) return o.y-this.y;
            return this.x-o.x;
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();
        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int sum = 0;
        int bfX = pq.peek().x;
        int bfY = pq.peek().y;
        pq.poll();
        while (!pq.isEmpty()) {
            Line cur = pq.poll();
            if (cur.x > bfY) {
                sum += bfY-bfX;
                bfX = cur.x;
                bfY = cur.y;
                continue;
            }
            bfY = Math.max(bfY, cur.y);
        }
        System.out.println(sum+bfY-bfX);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
