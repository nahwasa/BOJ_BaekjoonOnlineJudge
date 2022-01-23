import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())-1;
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(Integer.parseInt(st.nextToken()));
        int sum = dq.peekLast();
        int answer = Integer.MAX_VALUE;
        while (!dq.isEmpty()) {
            if (sum >= s) {
                answer = Math.min(answer, dq.size());
                sum -= dq.pollFirst();
                continue;
            }
            if (n == 0) break;
            n--;
            dq.addLast(Integer.parseInt(st.nextToken()));
            sum += dq.peekLast();
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
