import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long cur = Integer.parseInt(st.nextToken());
        long s = cur-1;
        if (s < 0) s = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (--k>0) {
            long tmp = Integer.parseInt(st.nextToken());
            pq.add(tmp-cur-1);
            cur = tmp;
        }

        long e = n-cur;

        long sum = 0;
        while (d>3 && !pq.isEmpty()) {
            sum+=pq.poll();
            d-=2;
        }

        if (d==1) {
            sum += Math.max(s, e);
        } else if (d==3) {
            sum += Math.max(s+e, pq.isEmpty()?0:pq.poll()+(Math.max(s,e)));
        } else {
            sum += Math.max(s+e, pq.isEmpty()?0:pq.poll());
        }

        System.out.println(sum);
    }
}
