import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        while (true) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == -1) break;
            if (cur == 0) q.poll();
            else if (q.size() < n) q.add(cur);
        }
        if (q.size() == 0) {
            System.out.println("empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll()).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
