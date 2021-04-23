import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                pq.add(tmp);
                continue;
            }
            sb.append(pq.isEmpty()?0:pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}
