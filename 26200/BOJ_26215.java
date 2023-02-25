import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int LIMIT = 2000000;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0)
            pq.add(Integer.parseInt(st.nextToken()));

        int answer = 0;
        while (pq.size() > 2) {
            int a = pq.poll();
            int b = pq.poll();
            answer += b;
            if (a-b!=0) pq.add(a-b);
        }
        answer += pq.isEmpty() ? 0 : pq.poll();
        System.out.println(answer>1440?-1 : answer);
    }
}
