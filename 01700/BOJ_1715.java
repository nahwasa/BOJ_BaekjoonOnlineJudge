import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(n-->0) pq.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        while(pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            sum+=tmp;
            pq.add(tmp);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
